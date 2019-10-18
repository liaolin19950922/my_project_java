package com.myProject.service;

import java.util.List;
import java.util.Map;

import com.myProject.bean.User;

public interface IUserService {
	
	public int save(User user);
	
	public int update(User user);
	
	public int deleteByPrimarykey(String userId);

	public List<User> listUser(Map<String, Object> map);
}
