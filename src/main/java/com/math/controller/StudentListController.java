package com.math.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.math.domain.TeachersVO;
import com.math.service.StudentListService;
import com.math.service.TeacherService;
import com.math.util.JsonUtil;

@Controller
@RequestMapping("/Student")
public class StudentListController {
	
	@Inject
	private StudentListService service;
	
	@RequestMapping(value="/9010", method=RequestMethod.GET)
	public ModelAndView list() throws Exception {
		//System.out.println("/admin/9010 called");
		List<Map<String, Object>> list = service.StudentList(0);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/students/studentList");
		mav.addObject("list", list);
		return mav;
	}
	
}
