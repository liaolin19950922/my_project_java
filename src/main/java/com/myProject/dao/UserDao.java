package com.myProject.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myProject.bean.User;

@Mapper
public interface UserDao {
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(String userId);
	
    public List<User> selectList(Map<String,Object> map);
    
    public User selectUser(String userId);
}
