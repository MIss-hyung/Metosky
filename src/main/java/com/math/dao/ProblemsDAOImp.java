package com.math.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.math.domain.ProblemsVO;

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

	@Override
	public List<String> getsourcelist(String p_subject) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+ ".sourceList", p_subject);
	}
	
	@Override
	public List<String> getunitlist(String p_subject ,String p_source) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> sqlmap = new HashMap<>();
		sqlmap.put(p_subject, p_subject);
		sqlmap.put(p_source, p_subject);
		return sqlSession.selectList(namespace+ ".unitList", sqlmap);
	}

	@Override
	public List<String> getdifficultylist(String p_subject , String p_source, String p_unit) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> sqlmap = new HashMap<>();
		sqlmap.put(p_subject, p_subject);
		sqlmap.put(p_source, p_subject);
		sqlmap.put(p_unit, p_unit);
		return sqlSession.selectList(namespace+ ".difficultyList", sqlmap);
	}

	@Override
	public String getS3codes(String p_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".s3codeList",p_code);
	}
}
