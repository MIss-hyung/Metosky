package com.math.service;

import com.math.dao.ProblemsDAO;
import javax.inject.Inject;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.math.dao.ProblemsDAO;
import com.math.domain.ProblemsVO;

public class ProblemServiceImp implements ProblemService {
	
	@Inject
	private ProblemsDAO dao;

	@Override
	public String problemTest(String p_code) throws Exception {
		// TODO Auto-generated method stub
		return dao.problemTest(p_code);
	}
	/*
	public void problemTest(ProblemsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.ProblemTest(vo);
	}*/
}
