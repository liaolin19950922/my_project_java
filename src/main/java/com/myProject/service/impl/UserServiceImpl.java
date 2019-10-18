package com.myProject.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myProject.bean.User;
import com.myProject.dao.UserDao;
import com.myProject.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public int save(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int update(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> listUser(Map<String,Object> map) {
		return userDao.selectList(map);
	}

	@Override
	public int deleteByPrimarykey(String userId) {
		return userDao.deleteUser(userId);
	}

}
