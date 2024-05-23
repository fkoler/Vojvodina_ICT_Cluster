package com.iktobuka.upload_example.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iktobuka.upload_example.services.FileHandler;

@Controller
@RequestMapping(path = "/")
public class UploadController {

	@Autowired
	private FileHandler fileHandler;

	@GetMapping
	public String index() {
		return "upload";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	@PostMapping("/upload")
	public String singleFileUpload(
			@RequestParam("file") MultipartFile file, 
			RedirectAttributes redirectAttributes
		) {
		String result = null;
		
		try {
			result = fileHandler.singleFileUpload(file, redirectAttributes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
