package com.math.service;

import java.util.List;
import java.util.Map;

public interface MenuManagerService {
	public List<Map<String,Object>> menuList(int access_type) throws Exception;
}
