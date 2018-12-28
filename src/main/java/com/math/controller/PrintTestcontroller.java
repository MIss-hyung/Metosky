package com.math.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
      
      if(vo.getIs_admin() == 1) {
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
     
      if(selected_students !=null) {
    	  selected_students=selected_students.substring(0, selected_students.length()-1);
      }
      
      mav.addObject("selected_students", selected_students);
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
     String today = sdf2.format(date).toString();
    		 
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
     
     
     List<byte[]> ImgByteList = new ArrayList<>();
     
     //파일 byte 정보 불러와서 저장
     for(int i=0; i<s3_codes.size(); i++) {
        byte[] demBytes = s3Util.getFileInfo(bucketName, directoryName+s3_codes.get(i)+".jpg");
        ImgByteList.add(demBytes);
     }
     
     XSSFWorkbook wb = new XSSFWorkbook();
     int page_index =0 ;
     
     int col1=3, row1=10, col2=13, row2=10;
     if(index==2) {
        row2 = 8;
     }
     XSSFSheet sheet = wb.createSheet(page_index+1+"_page");
     
     XSSFCell cell = sheet.createRow(1).createCell(4);
     cell.setCellValue("날짜 : " + today + "문제 코드 : " + print_p_code);
 
     
     List<int[]> indexlist = new ArrayList<>();
     
	for(int i=0; i<ImgByteList.size(); i++) {
			boolean newsheet = false;
			int[] index_of_img =new int[4];
			
	        if( i!=0 && i % index==0) {
	           page_index+=1;
	           sheet = wb.createSheet(page_index+1+"_page");
	           col1=3;
	           row1=10;
	           newsheet = true;
	        }
	        int picture = wb.addPicture(ImgByteList.get(i), XSSFWorkbook.PICTURE_TYPE_JPEG);

	         CreationHelper helper = wb.getCreationHelper();
	         Drawing drawing = sheet.createDrawingPatriarch();
	         ClientAnchor anchor = helper.createClientAnchor();
	         
	         anchor.setCol1(col1); 
	         anchor.setRow1(row1);
	         anchor.setCol2(col2); 
	         anchor.setRow2(row2);
	         
	
	         Picture pict = drawing.createPicture(anchor, picture);
	         pict.resize();
	         
	         index_of_img[0]=pict.getPreferredSize().getRow1();
	         index_of_img[1]=pict.getPreferredSize().getCol1();
	         index_of_img[2]=pict.getPreferredSize().getRow2();
	         index_of_img[3]=pict.getPreferredSize().getCol2();
	         indexlist.add(index_of_img);
	         
	         if(index==2) {
		            row1 = pict.getPreferredSize().getRow2()+5;
		         }else {
		           if(i%2==0) {
		              col1=pict.getPreferredSize().getCol2()+2;
		              if(i-1 <0 || newsheet) {
		            	  row1 =pict.getPreferredSize().getRow1();
		              }else {
		            	  row1 = indexlist.get(i-1)[2]+3;
		              }
		            }else {
		              col1= 3;
		              row1 = indexlist.get(i-1)[2]+3;
		            }
		         }

	      }
	      
		  String fileName= sdf.format(date).toString()+".xlsx";
	      response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName);
	      OutputStream fileOut = response.getOutputStream();
	      wb.write(fileOut);
	      fileOut.close();
	      
   }
}