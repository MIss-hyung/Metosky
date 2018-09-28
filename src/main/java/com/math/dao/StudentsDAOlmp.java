package com.math.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.math.domain.StudentsVO;

@Repository
public class StudentsDAOlmp implements StudentsDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.math.dao.StudentsDAO";
	
	@Override
	public List<Map<String,Object>> studentsList(int t_status) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".studentsList", t_status);
	}

	@Override
	public List<Map<String, Object>> studentList(int t_status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void studentList(StudentsVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
