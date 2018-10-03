package com.math.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.math.domain.TeachersVO;
import com.math.service.StudentListService;

@Controller
@RequestMapping("/problems")
public class PrintTestcontroller {
	
	@Inject
	private StudentListService service;
	
	@RequestMapping(value="/3010", method=RequestMethod.GET)
	public ModelAndView printMathsTest(Model model, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("login");
		TeachersVO vo = (TeachersVO) obj;
		
		if(vo.getIs_admin() == 1) {// 어드민이면 
			List<Map<String, Object>> list = service.AdminstudentsList();

			ModelAndView mav = new ModelAndView();
			mav.setViewName("/students/studentsList");
			mav.addObject("list", list);
			return mav;
			
		}else { //아닌경우
			List<Map<String, Object>> list = service.StudentsList(vo.getT_id());

			ModelAndView mav = new ModelAndView();
			mav.setViewName("/students/studentsList");
			mav.addObject("list", list);
			return mav;
		}
		//return "problems/printMathsTest";
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
