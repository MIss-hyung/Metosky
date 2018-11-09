package com.math.service;

import java.util.List;
import java.util.Map;

import com.math.domain.TeachersVO;

public interface StudentListService {

	public List<Map<String, Object>> StudentsList(int t_id) throws Exception;
	public List<Map<String,Object>> AdminstudentsList() throws Exception;
}
