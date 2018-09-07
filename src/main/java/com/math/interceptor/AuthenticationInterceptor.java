package com.math.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 처리를 담당하는 인터셉터
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	// preHandle() : 컨트롤러보다 먼저 수행됨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("login");
		
		if(obj == null) {//로그인이 안되어 있는 상태 -> 로그인 폼으로 돌려보냄
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}
	
	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
