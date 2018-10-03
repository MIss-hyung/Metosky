package com.math.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/st")
public class MainController {
	
	@RequestMapping(value="/2010", method=RequestMethod.GET)
	public String showDashboard( Model model, HttpSession session) throws Exception{
		System.out.println("/students/studentsList GET 방식입니다.");
		return "students/studentsList";
	}
}
