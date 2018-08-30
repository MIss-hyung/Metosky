package com.math.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.math.domain.TeachersVO;
import com.math.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeachersController {
	
	@Inject
	private TeacherService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void insertTeacherGET(TeachersVO teacher, Model model) throws Exception{
		System.out.println(" /teacher/register 입니다. GET 방식");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String insertTeacherPOST(TeachersVO teacher, Model model) throws Exception{
		System.out.println("/teacher/register POST 방식입니다.");
		
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ct = sdf.format(date);
		teacher.setCreated(ct);
		
		System.out.println(teacher.toString());
		service.insertTeacher(teacher);
		model.addAttribute("result", "성공");
		
		return "redirect:/index";
	}
}
