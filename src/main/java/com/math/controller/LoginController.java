package com.math.controller;

import java.io.PrintWriter;

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
   public String loginPost(TeachersVO teacher, HttpSession session, HttpServletResponse response) throws Exception{

      ModelAndView mav = new ModelAndView();
      String returnURL = "";
      
      if(session.getAttribute("login") != null) {
         session.removeAttribute("login");
      }
      
      TeachersVO vo = service.login(teacher);
      
      if(vo != null) {
         session.setAttribute("login",vo);

         if(vo.getIs_admin() == 1) {
            returnURL = "redirect:/admin/9010";
         }else {
        	 
            returnURL = "redirect:/teacher/2010";
         }
      }else {
    	  response.setContentType("text/html; charset=UTF-8");
    	  PrintWriter out = response.getWriter();
    	  out.println("<script>alert('로그인 실패'); history.go(-1);</script>");
    	  out.flush();
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