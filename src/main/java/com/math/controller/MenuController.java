package com.math.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.math.service.MenuManagerService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Inject
	private MenuManagerService service;
	
	@RequestMapping(value="/getMenuList/{accessType}", method=RequestMethod.POST)
	public ModelAndView getMenuList(@PathVariable String accessType) throws Exception {
		List<Map<String, Object>> list = service.menuList(2);
		
		if(accessType == "admin") {
			list = service.menuList(1);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("include/header");
		mav.addObject("list", list);
		
		return mav;
	}
}
