package com.math.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.math.dao.MenuDAO;
import com.math.domain.MenuManagerVO;

@Service
public class MenuServiceImpl implements MenuService {

	@Inject
	private MenuDAO dao;
	
	@Override
	public List<MenuManagerVO> menuManager() throws Exception {
		// TODO Auto-generated method stub
		return dao.menuManager();
	}
	
}
