package com.math.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.math.domain.StudentsVO;
import com.math.domain.TeachersVO;
import com.math.service.StudentListService;
import com.math.service.TeacherService;
import com.math.util.JsonUtil;

@Controller
@RequestMapping("/teacher")
public class StudentListController {
	
	@Inject
	private StudentListService service;
	
	@RequestMapping(value="/2010", method=RequestMethod.GET)
	public ModelAndView list(HttpSession session) throws Exception {
		//System.out.println("/admin/9010 called");
		Object obj = session.getAttribute("login");
		TeachersVO vo = (TeachersVO) obj;
		
		List<Map<String, Object>> list = service.StudentsList(vo.getT_id());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/students/studentsList");
		mav.addObject("list", list);
		return mav;
	}

}
