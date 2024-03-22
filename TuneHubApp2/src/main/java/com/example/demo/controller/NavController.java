package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NavController {
	
	@GetMapping("map-register")
	public String registerMapping() {
		return "register";
	}
	
	@GetMapping("map-login")
	public String loginMapping() {
		return "login";
	}
	@GetMapping("map-song")
	public String songMapping() {
		return "addsongs";
	}
//	@GetMapping("map-view")
//	public String viewSong() {
//		return "viewsong";
//	}
	@GetMapping("samplepayment")
	public String samplepayment() {
		return "samplepayment";
	}
	
//	
	
}
