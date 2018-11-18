package com.math.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.math.domain.ProblemsVO;
import com.math.domain.TeachersVO;
import com.math.service.ProblemsService;
import com.math.service.StudentListService;

@Controller
@RequestMapping("/problems")
public class PrintTestcontroller {
   
   @Inject
   private StudentListService service;
   @Inject
   private ProblemsService service2;
   
   @RequestMapping(value="/3010", method=RequestMethod.GET)
   public ModelAndView printMathsTest(Model model, HttpSession session) throws Exception {
      
      Object obj = session.getAttribute("login");
      TeachersVO vo = (TeachersVO) obj;
      
      if(vo.getIs_admin() == 1) {//
         List<Map<String, Object>> list = service.AdminstudentsList();

         ModelAndView mav = new ModelAndView();
         mav.setViewName("/problems/printMathsTest");
         mav.addObject("list", list);
         
         return mav;
         
      }else { 
         List<Map<String, Object>> list = service.StudentsList(vo.getT_id());

         ModelAndView mav = new ModelAndView();
         mav.setViewName("/problems/printMathsTest");
         mav.addObject("list", list);
         return mav;
      }
      //return "problems/printMathsTest";
   }
   
   @RequestMapping(value="/3020", method=RequestMethod.GET)
   public String printStudentGotWrong(Model model, HttpSession session) throws Exception {
      return "problems/printStudentGotWrong";
   }
   
   @RequestMapping(value="/3030", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView problemSettings(Model model, HttpSession session,@RequestParam("selected_students") String selected_students) throws Exception {
      ModelAndView mav= new ModelAndView();
     // System.out.println(selected_students + " << 학생값 받아오나 ");
      selected_students=selected_students.substring(0, selected_students.length()-1);
   
      mav.addObject("selected_students", selected_students);
      mav.setViewName("/problems/problemSettings");

      return mav;
   }
   
   @ResponseBody
   @RequestMapping(value="/downTest", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView FileEx(Model model, HttpSession session, HttpServletRequest request) throws Exception {
	  String problemS=request.getParameter("ps");
	  problemS=problemS.substring(0, problemS.length()-1);
	  
	  String[] pstoArray=problemS.split("[$]");
	  
	  List<ProblemsVO> pvolist=new ArrayList<ProblemsVO>();
	  ProblemsVO eachp = null; //객체의 이름을 담는다.
	  
	  for(int j=0; j<pstoArray.length; j++) {
		  if(j%5==0) {
			  eachp=new ProblemsVO();
			  eachp.setP_subject(pstoArray[j]);
		  }
		  else if(j%5==1) eachp.setP_source(pstoArray[j]);
		  else if(j%5==2) eachp.setP_unit(pstoArray[j]);
		  else if(j%5==3) eachp.setP_difficulty(pstoArray[j]);
		  else if(j%5==4) {
			  eachp.setP_size(Integer.parseInt(pstoArray[j]));
			  pvolist.add(eachp);
		  }
	  }
	  //p code 뽑아오기
	  List<String> p_codes=new ArrayList<>();
	  
	  for(ProblemsVO pv: pvolist) {
		  p_codes.addAll(service2.problemList(pv));
	  }
	  
	  System.out.println("P_CODE 출력");
	  for(String k:p_codes) {
		  System.out.print(k + " /");
	  }
	  
	  //
	  ModelAndView mav=new ModelAndView();
      mav.setViewName("/problems/printunder");
      mav.addObject("eachproblem", pvolist);
      return mav;
   }
}