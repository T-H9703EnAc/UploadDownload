package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.services.DownloadService;
import com.app.services.UploadService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UploadDownController {
	@Autowired
	UploadService uploadService;
	
	@Autowired
	DownloadService downloadService;
	
	/**
	 * ファイルアップロードAPI
	 * @param file アップロードしたファイル
	 */
	@PostMapping(value = "/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		uploadService.fileUpload(file);
	}
	
	/**
	 * ファイルアップロードAPI
	 * @param file アップロードしたファイル
	 */
	@PostMapping(value = "/downloadFile")
	public void downloadFile(HttpServletResponse response) {
		downloadService.fileDownload(response);
	}
	
}
