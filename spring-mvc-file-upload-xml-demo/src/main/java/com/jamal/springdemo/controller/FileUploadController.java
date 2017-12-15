package com.jamal.springdemo.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/uploadFileDemo")
public class FileUploadController {
	private static Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String handleGet() {
		LOGGER.info("Inside handleGet");
		return "test/fileUploadTestViews/fileUpload";
	}

	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public String handlePost(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
		LOGGER.info("Inside handlePost");
		String name = multipartFile.getOriginalFilename();
		BufferedWriter w = Files.newBufferedWriter(Paths.get("E:\\jamal\\filesUploaded\\" + name));
		w.write(new String(multipartFile.getBytes()));
		w.flush();
		w.close();

		model.addAttribute("msg", "File has been uploaded:  " + name);
		return "test/fileUploadTestViews/response";
	}

	//@RequestMapping(method = RequestMethod.POST)
	public String handlePostRequest(MultipartHttpServletRequest request, Model model) throws IOException {
		MultipartFile multipartFile = request.getFile("file");

		String name = multipartFile.getOriginalFilename();
		BufferedWriter w = Files.newBufferedWriter(Paths.get("E:\\jamal\\filesUploaded\\" + name));
		w.write(new String(multipartFile.getBytes()));
		w.flush();
		w.close();

		model.addAttribute("msg", "File has been uploaded:  " + name);
		return "test/fileUploadTestViews/response";
	}
}
