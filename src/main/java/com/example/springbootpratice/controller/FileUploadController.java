package com.example.springbootpratice.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String FileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		
		File convertFile = new File("C:\\Users\\kavita.venkatesan\\Documents\\STS\\var\\tmp"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream foout = new FileOutputStream(convertFile);
		foout.write(file.getBytes());
		foout.close();
		return "File uploaded successfully!!";
		
	}
}
