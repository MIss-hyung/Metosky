package com.math.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import com.math.domain.ProblemsVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProblemsDAOImp implements ProblemsDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.math.dao.ProblemsDAO";
	
	@Override
	public List<Map<String, Object>> problemSelectList() throws Exception{
		return sqlSession.selectList(namespace+".problemSelectList");
	}
	
	/*
	public String ProblemTest(ProblemsVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".problemTest", vo);
	}

	@Override
	public String problemTest(String p_code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	@Override
	public List<String> problemList(ProblemsVO pv) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".problemList", pv);
	}

	@Override
	public List<String> getsubjectlist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+ ".subjectList");
	}
}
