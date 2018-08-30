package com.math.metosky;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.math.dao.TeachersDAO;
import com.math.domain.TeachersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
			locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class TeacherDAOTest {
	@Inject
	private TeachersDAO dao;
	
	@Test
	public void testInsertTeachers() throws Exception{
		TeachersVO vo = new TeachersVO();
		vo.setT_email("test@al.com");
		vo.setT_pswd("1234qwer");
		vo.setT_name("test001");
		
		java.util.Date date = new java.util.Date(); 
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String currentTime = sdf.format(date);

		vo.setCreated(currentTime);
		dao.insertTeacher(vo);
	}
}
