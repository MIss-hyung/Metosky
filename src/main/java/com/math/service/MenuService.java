package com.math.service;

import java.util.List;

import com.math.domain.MenuManagerVO;

public interface MenuService {
	public List<MenuManagerVO> menuManager() throws Exception;
}
