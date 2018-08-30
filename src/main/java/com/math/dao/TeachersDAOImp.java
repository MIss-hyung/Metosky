package com.math.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.math.domain.TeachersVO;

@Repository
public class TeachersDAOImp implements TeachersDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.math.dao.TeachersDAO";
	
	@Override
	public void insertTeacher(TeachersVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertTeacher", vo);
	}
	
}
