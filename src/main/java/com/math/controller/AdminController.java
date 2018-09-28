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
import com.math.service.TeacherService;
import com.math.util.JsonUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	private TeacherService service;
	
	@RequestMapping(value="/9010", method=RequestMethod.GET)
	public ModelAndView signUpList() throws Exception {
		List<Map<String, Object>> list = service.teachersList(0);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/allowSignUp");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/9020", method=RequestMethod.GET)
	public ModelAndView acceptedList() throws Exception {
		List<Map<String, Object>> list = service.teachersList(1);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/teachersList");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/9030", method=RequestMethod.GET)
	public ModelAndView notAcceptedList() throws Exception {
		List<Map<String, Object>> list = service.teachersList(-1);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/notAccepted");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/signUpApprove", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> signUpApprove(@RequestBody String filterJSON) throws Exception {
		TeachersVO teacher = new TeachersVO();
		
		Map<String, Object> filter = JsonUtil.convertJsonToObject(filterJSON);
		
		String id = (String) filter.get("t_id");
		String status = (String) filter.get("t_status");
		
		int t_id = Integer.parseInt(id);
		int t_status = Integer.parseInt(status);
		
		teacher.setT_id(t_id);
		teacher.setT_status(t_status);
		
		System.out.println("t_id : " + t_id + ",t_status : " + t_status);
		service.approveTeacher(teacher);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", true);
		return map;
	}
}
