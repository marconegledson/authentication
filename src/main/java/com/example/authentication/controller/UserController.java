package com.example.authentication.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value =  "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String getUsers() {
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}, {\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}
	
}
