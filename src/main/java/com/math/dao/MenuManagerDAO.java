package com.math.dao;

import java.util.List;
import java.util.Map;

public interface MenuManagerDAO {
	public List<Map<String,Object>> menuList(int access_type) throws Exception;
}
