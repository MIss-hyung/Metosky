package com.math.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MenuManagerDAOImp implements MenuManagerDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.math.dao.MenuManagerDAO";

	@Override
	public List<Map<String, Object>> menuList(int access_type) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".menuList", access_type);
	}

}
