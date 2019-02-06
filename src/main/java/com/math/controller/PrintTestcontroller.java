package com.math.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.core.io.ClassPathResource;
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
import com.math.service.S3Service;
import com.math.service.S3Util;
import com.math.service.StudentListService;

@Controller
@RequestMapping("/problems")
public class PrintTestcontroller {
	String bucketName="problems-image";
	String directoryName="test/";
	   
   @Inject
   private StudentListService service;
   @Inject
   private ProblemsService service2;
   @Inject
   private S3Service s3service;
   S3Util s3Util=new S3Util();

   @RequestMapping(value="/logout", method = RequestMethod.GET)
   public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
      Object obj = session.getAttribute("login");
      
      if(obj != null) {
         TeachersVO vo = (TeachersVO) obj;
         session.removeAttribute("login");
         session.invalidate();
         //req.getparameter
      }
      
      return "redirect:/";
   }
  
   
   @RequestMapping(value="/3010", method=RequestMethod.GET)
   public ModelAndView printMathsTest(Model model, HttpSession session) throws Exception {
      
      Object obj = session.getAttribute("login");
      TeachersVO vo = (TeachersVO) obj;
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/problems/printMathsTest");
      
      try {
	      if(vo.getIs_admin() == 1) {
	         List<Map<String, Object>> list = service.AdminstudentsList();
	         mav.addObject("list", list);
	         return mav;
	      }else { 
	         List<Map<String, Object>> list = service.StudentsList(vo.getT_id());
	         mav.addObject("list", list);
	         return mav;
	      }
      }catch(Exception e) {
    	  return mav;
      }
   }
   
   @RequestMapping(value="/3020", method=RequestMethod.GET)
   public String printStudentGotWrong(Model model, HttpSession session) throws Exception {
      return "problems/printStudentGotWrong";
   }
   
   @RequestMapping(value="/3030", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView problemSettings(Model model, HttpSession session,@RequestParam("selected_students") String selected_students) throws Exception {
	  
	  List<Map<String, Object>> list = service2.problemSelectList();
	  List<String> subjectlist = service2.getsubjectlist();

      ModelAndView mav= new ModelAndView();
     
      if(selected_students !="") {
    	  selected_students=selected_students.substring(0, selected_students.length()-1);
    	  mav.addObject("selected_students", selected_students);
    	  }
      mav.addObject("list", list);
      mav.addObject("subjectlist", subjectlist);
      mav.setViewName("/problems/problemSettings");

      return mav;
   }
   
   @ResponseBody
   @RequestMapping(value="/selectP", produces = "application/json;charset=utf8", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView selectP(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   //response.setCharacterEncoding(UTF-8);
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("/problems/makingForEach");
	   
	   String requestvalue=request.getParameter("p");
	   System.out.println(requestvalue);
	   
	   
	   List<String> sourcelist = service2.getsourcelist(requestvalue);
	   mv.addObject("sourcelist",sourcelist);
	   return mv;
   }
   
   @ResponseBody
   @RequestMapping(value="/selectPa", produces = "application/json;charset=utf8", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView selectPa(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   //response.setCharacterEncoding(UTF-8);
	   ModelAndView mv = new ModelAndView();
	   String requestvalue=request.getParameter("pa");
	   String requestSource = request.getParameter("psource");
	   
	   ProblemsVO pv = new ProblemsVO();
	   pv.setP_subject(requestvalue);
	   pv.setP_source(requestSource);
	   
	   List<String> unitlist = service2.getunitlist(pv);
	   
	   mv.setViewName("/problems/makingForEach");
	   mv.addObject("sourcelist",unitlist);
	   
	   return mv;
   }

   @ResponseBody
   @RequestMapping(value="/selectPaP", produces = "application/json;charset=utf8", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView selectPaP(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   //response.setCharacterEncoding(UTF-8);
	   ModelAndView mv = new ModelAndView();
	   String requestvalue=request.getParameter("pa");
	   String requestSource = request.getParameter("psource");
	   String requestUnit = request.getParameter("punit");
	   
	   
	   ProblemsVO pv = new ProblemsVO();
	   pv.setP_source(requestSource);
	   pv.setP_unit(requestUnit);
	   pv.setP_subject(requestvalue);
	   
	   List<String> difficultylist = service2.getdifficultylist(pv);
	   mv.setViewName("/problems/makingForEach");
	   mv.addObject("sourcelist", difficultylist);
	   
	   return mv;
   }
   
   @ResponseBody
   @RequestMapping(value="/fileDown",produces="application/json; charset=utf8", method = {RequestMethod.GET, RequestMethod.POST})
   public void FileEx(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
     String problemS=request.getParameter("ps");
     problemS=problemS.substring(0, problemS.length()-1);
     String indexstr=request.getParameter("printBy");
     int index = Integer.parseInt(indexstr);
     String[] pstoArray=problemS.split("[$]");
     
     Date date= new Date();
     SimpleDateFormat sdf =new SimpleDateFormat("yyyy_MM_dd_hh_mm");
     SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
     String fileName = sdf2.format(date).toString()+".docx";
     
     List<ProblemsVO> pvolist=new ArrayList<ProblemsVO>();
     ProblemsVO eachp = null; //媛앹껜�쓽 �씠由꾩쓣 �떞�뒗�떎.
     
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
     
     List<String> p_codes=new ArrayList<>();
     List<String> s3_codes= new ArrayList<>();
     
     for(ProblemsVO pv: pvolist) {
        p_codes.addAll(service2.problemList(pv));
     }
     String print_p_code="";
     
     for(String p_code: p_codes) {
        s3_codes.add(service2.getS3codes(p_code));
        print_p_code +=p_code +", ";
     }
     
     ClassPathResource resource = new ClassPathResource("file/doctest.docx");
	   File file = resource.getFile();
	   FileInputStream fis = new FileInputStream(file);
      XWPFDocument document = new XWPFDocument(fis);
      
     XWPFParagraph paragh = document.getParagraphs().get(0);
     XWPFRun run = paragh.createRun();
     
     run.setText(print_p_code);
     run.addBreak();
     
     int width = 260;
     for(int i=0; i<s3_codes.size(); i++) {
        byte[] demBytes = s3Util.getFileInfo(bucketName, directoryName+s3_codes.get(i)+".jpg");
        ByteArrayInputStream img = new ByteArrayInputStream(demBytes);
        BufferedImage bi= ImageIO.read(new ByteArrayInputStream(demBytes));
        double height = (double)bi.getHeight()/bi.getWidth()*width;
	    run.addPicture(img, Document.PICTURE_TYPE_JPEG, s3_codes.get(i), Units.toEMU(width), Units.toEMU(height));
	    run.addBreak();
	    run.addBreak();
	    run.addBreak();
	    run.addBreak();
	    run.addBreak();
     }
     

     response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName);
	    OutputStream fileOut = response.getOutputStream();
	    document.write(fileOut);
	     fileOut.close();
   }

}