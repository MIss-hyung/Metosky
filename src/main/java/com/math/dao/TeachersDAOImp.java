package com.math.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public TeachersVO login(TeachersVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".login", vo);
	}

	@Override
	public List<Map<String,Object>> teachersList(int t_status) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".teachersList", t_status);
	}

	@Override
	public void approveTeacher(TeachersVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".approveTeacher", vo);
	}
/*
	@Override
	public void keepLogin(String t_email, String sessionId, Date sessionLimit) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TeachersVO checkUserWithSessionKey(String value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	//로그인 유지 처리
	/*
	@Override
	public void keepLogin(String t_email, String sessionId, Date sessionLimit) throws Exception{
		Map<String,Object>paramMap = new HashMap<>();
		paramMap.put("t_email", t_email);
		paramMap.put("sessionId", sessionId);
		paramMap.put("sessionLimit", sessionLimit);
		
		sqlSession.update(NAMESPACE + "/keepLogin", paramMap);
	}
	
	//세션키 검증
	@Override
	public TeachersVO checkUserWithSessionKey(String value) throws Exception{
		return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
	}
	*/
}
