package com.kornelius.studycase3.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	 @RequestMapping("")
	   public String index() {
	      return "home/index";
	   }

}
