package com.math.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.math.domain.TeachersVO;
import com.math.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class LoginController {
	
	@Inject
	private TeacherService service;
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(TeachersVO teacher) throws Exception{
		return "/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(TeachersVO teacher, HttpSession session) throws Exception{
		System.out.println("/login POST 방식 입니다.");
		String returnURL = "";
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		TeachersVO vo = service.login(teacher);
		
		if(vo != null) {
			session.setAttribute("login",vo);
			returnURL = "redirect:/teacher/dashboard";
		}else {
			returnURL = "redirect:/";
		}
		
		return returnURL;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		Object obj = session.getAttribute("login");
		
		if(obj != null) {
			TeachersVO vo = (TeachersVO) obj;
			session.removeAttribute("login");
			session.invalidate();
		}
		
		return "redirect:/";
	}
}
