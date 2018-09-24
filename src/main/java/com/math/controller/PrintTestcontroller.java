package com.math.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/problems")
public class PrintTestcontroller {
	
	@RequestMapping(value="/3010", method=RequestMethod.GET)
	public String printMathsTest(Model model, HttpSession session) throws Exception {
		return "problems/printMathsTest";
	}
	
	@RequestMapping(value="/3020", method=RequestMethod.GET)
	public String printStudentGotWrong(Model model, HttpSession session) throws Exception {
		return "problems/printStudentGotWrong";
	}
	
	@RequestMapping(value="/3030", method=RequestMethod.GET)
	public String problemSettings(Model model, HttpSession session) throws Exception {
		return "problems/problemSettings";
	}
}
