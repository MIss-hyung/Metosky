package com.math.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.math.dao.ProblemsDAO;
import com.math.domain.ProblemsVO;

@Service
public class ProblemsServiceImp implements ProblemsService {
	
	@Inject
	private ProblemsDAO dao;
/*
	@Override
	public String problemTest(String p_code) throws Exception {
		// TODO Auto-generated method stub
		return dao.problemTest(p_code);
	}
	
	public void problemTest(ProblemsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.ProblemTest(vo);
	}*/
	
	@Override
	public List<String> problemList(ProblemsVO pv) throws Exception {
		return dao.problemList(pv);
	}
	@Override
	public List<Map<String, Object>> problemSelectList() throws Exception {
		// TODO Auto-generated method stub
		return dao.problemSelectList();
	}
	@Override
	public List<String> getsubjectlist() throws Exception{
		// TODO Auto-generated method stub
		return dao.getsubjectlist();
	}
	
}
