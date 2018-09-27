package com.math.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.math.dao.MenuManagerDAO;

@Service
public class MenuManagerServiceImp implements MenuManagerService {
	
	@Inject
	private MenuManagerDAO dao;

	@Override
	public List<Map<String, Object>> menuList(int access_type) throws Exception {
		// TODO Auto-generated method stub
		return dao.menuList(access_type);
	}

}
