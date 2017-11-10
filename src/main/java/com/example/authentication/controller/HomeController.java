package com.example.authentication.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value =  "/home", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String hello() {
		return "Hello buddy!";
	}
	
}
