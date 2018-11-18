package com.math.service;

import java.util.List;
import com.math.domain.ProblemsVO;

public interface ProblemsService {
	/*
	public void ProblemTest(ProblemsVO vo) throws Exception;
	}
	public String problemTest(String p_code) throws Exception;
	*/
	public List<String> problemList(ProblemsVO pv) throws Exception;
}
