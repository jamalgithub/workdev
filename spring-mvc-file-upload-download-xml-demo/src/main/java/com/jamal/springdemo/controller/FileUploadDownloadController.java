package com.jamal.springdemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jamal.springdemo.domain.FileInfo;

@Controller
@RequestMapping("/fileUploadDownloadDemo")
public class FileUploadDownloadController {

	@Autowired
    ServletContext context;
	
	@Autowired
	private Environment env;
 
	@RequestMapping(value = "/home")
	public String home() {
		return "test/fileUploadDownloadViews/index";
	}
	
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("file") List <MultipartFile> files) {
        List <FileInfo> uploadedFiles = new ArrayList <FileInfo> ();
        if (!files.isEmpty()) {
            try {
                for (MultipartFile file: files) {
                    //String path = context.getRealPath("/WEB-INF/uploaded") + File.separator + file.getOriginalFilename();
                    String path = env.getProperty("uploadDestination") + File.separator + file.getOriginalFilename();
                    File destinationFile = new File(path);
                    file.transferTo(destinationFile);
                    uploadedFiles.add(new FileInfo(destinationFile.getName(), path));
                }
 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        ModelAndView modelAndView = new ModelAndView("test/fileUploadDownloadViews/success");
        modelAndView.addObject("files", uploadedFiles);
        return modelAndView;
    }
    
    @RequestMapping("/download/{fileName:.+}")
    public void downloader(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName) {
        try {
            String downloadFolder = context.getRealPath("/WEB-INF/downloads");
            File file = new File(downloadFolder + File.separator + fileName);
 
            if (file.exists()) {
                String mimeType = context.getMimeType(file.getPath());
 
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
 
                response.setContentType(mimeType);
                response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setContentLength((int) file.length());
 
                OutputStream os = response.getOutputStream();
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int b = -1;
 
                while ((b = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, b);
                }
 
                fis.close();
                os.close();
            } else {
                System.out.println("Requested " + fileName + " file not found!!");
            }
        } catch (IOException e) {
            System.out.println("Error:- " + e.getMessage());
        }
    }
}
