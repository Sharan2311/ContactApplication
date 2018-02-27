package com.sharan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping("/test/hello")
public String helloworld() {
	return "hello";
}
}
