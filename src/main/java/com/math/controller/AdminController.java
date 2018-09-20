package com.math.controller;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.math.service.TeacherService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	private TeacherService service;
	
	@RequestMapping(value="/9010", method=RequestMethod.GET)
	public ModelAndView list() throws Exception {
		System.out.println("/admin/9010 called");
		List<Map<String, Object>> list = service.teachersList(0);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/allowSignUp");
		mav.addObject("list", list);
		return mav;
	}
}
