package com.math.dao;

import java.util.List;
import java.util.Map;

import com.math.domain.ProblemsVO;

public interface ProblemsDAO {
	//public String problemTest(String p_code) throws Exception;
	// public String problemTest(String vo) throws Exception;
	public List<String> problemList(ProblemsVO pv) throws Exception;

	public List<Map<String, Object>> problemSelectList() throws Exception;

	public List<String> getsubjectlist() throws Exception;

	public List<String> getsourcelist(String p_subject) throws Exception;
	public List<String> getunitlist(ProblemsVO pv) throws Exception;
	public List<String> getdifficultylist(ProblemsVO pv) throws Exception;
	public String getS3codes(String p_code) throws Exception;
}
