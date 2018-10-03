package com.math.dao;

import java.util.List;
import java.util.Map;

import com.math.domain.StudentsVO;

public interface StudentsDAO {
	public List<Map<String, Object>> studentsList(int t_id) throws Exception;
	public List<Map<String,Object>> AdminstudentsList() throws Exception;
}


