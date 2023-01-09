package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamenController {
	/**
	 * upload.htmlを表示するコントローラ
	 * @return upload.html 
	 */
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	/**
	 * download.htmlを表示するコントローラ
	 * @return upload.html 
	 */
	@GetMapping("/download")
	public String download() {
		return "download";
	}
}
