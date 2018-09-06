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

	@Override
	public int emailExistChk(String t_email) throws Exception {
		// TODO Auto-generated method stub
		int count = sqlSession.selectOne(namespace+".emailExistChk", t_email);
		return count;
	}
	
}
