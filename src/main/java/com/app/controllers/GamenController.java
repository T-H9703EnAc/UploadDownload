package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamenController {	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
}
