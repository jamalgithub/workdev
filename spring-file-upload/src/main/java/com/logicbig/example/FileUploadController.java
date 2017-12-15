package com.logicbig.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String handleGet () {
        return "file-upload";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost (@RequestParam("user-file") MultipartFile multipartFile,
                                     Model model) throws IOException {

        String name = multipartFile.getOriginalFilename();
        BufferedWriter w = Files.newBufferedWriter(Paths.get("d:\\filesUploaded\\" + name));
        w.write(new String(multipartFile.getBytes()));
        w.flush();


        model.addAttribute("msg", "File has been uploaded:  "+name);
        return "response";
    }
}