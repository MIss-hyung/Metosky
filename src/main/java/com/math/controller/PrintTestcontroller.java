package com.math.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
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

   
   
   @RequestMapping(value="/3010", method=RequestMethod.GET)
   public ModelAndView printMathsTest(Model model, HttpSession session) throws Exception {
      
      Object obj = session.getAttribute("login");
      TeachersVO vo = (TeachersVO) obj;
      
      if(vo.getIs_admin() == 1) {
         List<Map<String, Object>> list = service.AdminstudentsList();

         ModelAndView mav = new ModelAndView();
         mav.setViewName("/problems/printMathsTest");
         mav.addObject("list", list);
         System.out.println(" << 모든 학생값 받아오나? " + list);
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
	  
	  List<Map<String, Object>> list = service2.problemSelectList();
	  List<String> subjectlist = service2.getsubjectlist();

      ModelAndView mav= new ModelAndView();
      //System.out.println(selected_students + " << 학생값 받아오나 ");
     // System.out.println(list + " << 리스트값 받아오나? ");
      System.out.println(subjectlist+"<<subj"); //
      
      selected_students=selected_students.substring(0, selected_students.length()-1);
   
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
	   System.out.println(sourcelist+"<<이거는 내가 선택한 sub에 대한 p_source이다.");
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
	   System.out.println("RS"+requestSource);
	   
	   List<String> unitlist = service2.getunitlist(requestvalue, requestSource);
	   mv.setViewName("/problems/makingForEach");
	   mv.addObject("sourcelist",unitlist);
	   System.out.println(unitlist+"<<여기는 내가 선택한sourcelist에서의 unitlist이다");
	   
	   return mv;
   }

   @ResponseBody
   @RequestMapping(value="/selectPaP", produces = "application/json;charset=utf8", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView selectPaP(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   //response.setCharacterEncoding(UTF-8);
	   ModelAndView mv = new ModelAndView();
	   String requestvalue=request.getParameter("pap");
	   String requestSource = request.getParameter("psource");
	   String requestUnit = request.getParameter("punit");
	   System.out.println(requestvalue);
	   
	   List<String> difficultylist = service2.getdifficultylist(requestvalue, requestSource, requestUnit);
	   mv.setViewName("/problems/makingForEach");
	   mv.addObject("sourcelist", difficultylist);
	   System.out.println(difficultylist+"<<여기는 내가 선택한unitlist에서의 difficultylist이다");
	   
	   return mv;
   }

   @ResponseBody
   @RequestMapping(value="/downTest",produces="application/json; charset=utf8", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView FileEx(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
     int max_excel_width = 7;
     int max_excel_height = 42;
     String problemS=request.getParameter("ps");
     problemS=problemS.substring(0, problemS.length()-1);
     String indexstr=request.getParameter("page_in_problems");
     int index = Integer.parseInt(indexstr);
     String[] pstoArray=problemS.split("[$]");
     
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
     
     System.out.println("pvolist");
     for(ProblemsVO k : pvolist) {
        System.out.println(k.getP_source()+" " + k.getP_unit() + "  " + k.getP_unit() + "  " + k.getP_size());
     }
     //p code 戮묒븘�삤湲�
     
     List<String> p_codes=new ArrayList<>();
     List<String> s3_codes= new ArrayList<>();
     
     for(ProblemsVO pv: pvolist) {
        p_codes.addAll(service2.problemList(pv));
     }
     for(String p_code: p_codes) {
        s3_codes.add(service2.getS3codes(p_code));
     }
     
     List<byte[]> ImgByteList = new ArrayList<>();
     
     //파일 byte 정보 불러와서 저장
     for(int i=0; i<s3_codes.size(); i++) {
        byte[] demBytes = s3Util.getFileInfo(bucketName, directoryName+s3_codes.get(i)+".jpg");
        ImgByteList.add(demBytes);
     }
     
     XSSFWorkbook wb = new XSSFWorkbook();
      int page_index =0 ;
      
      int col1=0, row1=3, col2=8, row2=10;
      if(index==2) {
         row2 = 8;
      }
      XSSFSheet sheet = wb.createSheet(page_index+1+"_page");
     for(int i=0; i<ImgByteList.size(); i++) {
        if( i!=0 && i % index==0) {
           page_index+=1;
           sheet = wb.createSheet(page_index+1+"_page");
        }
        int picture = wb.addPicture(ImgByteList.get(i), XSSFWorkbook.PICTURE_TYPE_JPEG);
         
         CreationHelper helper = wb.getCreationHelper();
         Drawing drawing = sheet.createDrawingPatriarch();
         ClientAnchor anchor = helper.createClientAnchor();
         
         anchor.setCol1(col1); //Column B
         anchor.setRow1(row1); //Row 3
         anchor.setCol2(col2); //Column C
         anchor.setRow2(row2); //Row 4
         
         if(index==2) {
            row1 = row1 + 20;
            row2 = row2 + 20;
         }else {
           if(i%2==0) {
              col1=col1+10;
               col2=col2+10; 
            }else {
               col1= col1-10;
               col2= col2-10;
               row1=row1 + 15;
               row2=row2 + 15;            
            }
         }
        
         Picture pict = drawing.createPicture(anchor, picture);
      }
      
      //Write the Excel file
      FileOutputStream fileOut = null;
      fileOut = new FileOutputStream("C:\\Users\\LG\\Desktop\\filetest\\test3test.xlsx");
      wb.write(fileOut);
      fileOut.close();

     ModelAndView mav=new ModelAndView();
      mav.setViewName("/problems/Printunder");
      mav.addObject("eachproblem", pvolist);
      return mav;
   }
}