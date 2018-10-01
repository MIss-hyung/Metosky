package com.math.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		ModelAndView mav = new ModelAndView();
		String returnURL = "";
		//String msg= "로그인에 실패했습니다.";
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		TeachersVO vo = service.login(teacher);
		
		if(vo != null) {
			session.setAttribute("login",vo);
			/*
<<<<<<< HEAD
			returnURL = "redirect:/teacher/dashboard";
			//mav.setViewName("redirect:/teacher/dashboard");
			
=======
			if(vo.getIs_admin() == 1) {// admin이면 
				returnURL = "redirect:/admin/9010";
			}else {
				returnURL = "redirect:/teacher/2010";
			}
>>>>>>> e0a9b4f22ba4c9dc2801df9d6f20fd196fb96b82 */
		}else {
		//mav.addObject("msg","failure");
			returnURL = "redirect:/";
			//mav.setViewName("redirect:/");
			mav.addObject("msg","failure");
			
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
			//req.getparameter
		}
		
		return "redirect:/";
	}
	
}
