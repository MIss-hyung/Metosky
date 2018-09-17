package com.math.dao;

import java.util.List;

import com.math.domain.MenuManagerVO;

public interface MenuDAO {
	public List<MenuManagerVO> menuManager() throws Exception;
}
