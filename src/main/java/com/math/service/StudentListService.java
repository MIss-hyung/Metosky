package com.math.service;

import java.util.List;
import java.util.Map;

import com.math.domain.TeachersVO;

public interface StudentListService {

	public List<Map<String, Object>> StudentList(int t_status) throws Exception;

}
