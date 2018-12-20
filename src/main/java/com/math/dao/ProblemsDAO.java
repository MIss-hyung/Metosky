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
	public List<String> getunitlist(String p_subject,String p_source) throws Exception;
	public List<String> getdifficultylist(String p_subject , String p_source, String p_unit) throws Exception;
	public String getS3codes(String p_code) throws Exception;
}
