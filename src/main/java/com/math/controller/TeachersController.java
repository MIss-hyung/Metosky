package com.math.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.math.domain.TeachersVO;
import com.math.service.TeacherService;
import com.math.util.JsonUtil;

@Controller
@RequestMapping("/teacher")
public class TeachersController {
	
	@Inject
	private TeacherService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void insertTeacherGET(TeachersVO teacher, Model model) throws Exception{
		System.out.println(" /teacher/register 입니다. GET 방식");
	}
	
	 @RequestMapping(value="/emailcheck", method=RequestMethod.POST)
	 @ResponseBody	//register.jsp에서 ajax 호출을 이용해 email 값을 넘겨 받음
	 public Map<String, Object> emailExistChk(@RequestBody String filterJSON) throws Exception {
		int count = 0;
		
		Map<String, Object> filter = JsonUtil.convertJsonToObject(filterJSON);
		
		String t_email = filter.get("t_email").toString();
		
		System.out.println("t_email받은값은 : " + t_email);
		
		count = service.emailExistChk(t_email);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cnt", count);
		System.out.println("ajax pass");
		return map;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void insertTeacherPOST(TeachersVO teacher, Model model) throws Exception{
		System.out.println("/teacher/register POST 방식입니다.");
		
		// 새로고침 혹은 뒤로 가기 할 때 데이터가 중복으로 들어가는 것 예방
		int cnt = service.emailExistChk(teacher.getT_email());
		if(cnt != 0) return;
		//////////////////////////////////////
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ct = sdf.format(date);
		teacher.setCreated(ct);
		teacher.setIs_admin(0);//admin이 아닌 경우
		
		System.out.println(teacher.toString());
		service.insertTeacher(teacher);
	}
	
}
