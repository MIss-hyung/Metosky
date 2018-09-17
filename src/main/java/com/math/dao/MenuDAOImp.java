package com.math.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.math.domain.MenuManagerVO;

@Repository
public class MenuDAOImp implements MenuDAO{
	
	@Inject 
	private SqlSession sqlSession;
	
	private static final String namespace = "com.math.dao.MenuDAO";
	
	@Override
	public List<MenuManagerVO> menuManager() {
		
		return sqlSession.selectList(namespace + ".menuManager");
	}
	
}
