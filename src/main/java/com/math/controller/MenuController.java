package com.math.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.math.domain.MenuManagerVO;
import com.math.service.MenuService;

@Controller
@RequestMapping("/manager")
public class MenuController {
	
	@Inject
	private MenuService service;
	
	@RequestMapping(value="/menu", method=RequestMethod.POST)
	public ModelAndView menuList() throws Exception{
		List<MenuManagerVO> list = service.menuManager();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("include/header");
		mav.addObject("list", list);
		
		return mav;
	}
	
}
