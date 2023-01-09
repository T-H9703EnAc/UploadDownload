package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.services.UploadService;

@RestController
public class UploadController {
	@Autowired
	UploadService service;
	
	/**
	 * ファイルアップロードAPI
	 * @param file アップロードしたファイル
	 */
	@PostMapping(value = "/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		service.fileUpload(file);
	}
}
