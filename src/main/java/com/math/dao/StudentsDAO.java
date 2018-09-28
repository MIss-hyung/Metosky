package com.math.dao;

import java.util.List;
import java.util.Map;

import com.math.domain.StudentsVO;

public interface StudentsDAO {
	public void studentList(StudentsVO vo) throws Exception; //
	public List<Map<String, Object>> studentsList(int t_status) throws Exception;
}
