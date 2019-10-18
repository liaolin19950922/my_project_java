package com.myProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.myProject.bean.User;
import com.myProject.service.IUserService;


/**
 * 
 * @ClassName: UserController
 * @Desc: 用户注册的controller
 * @author: zhouming
 * @date: 2018年8月7日 下午1:43:16
 * @version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    
    @PostMapping("/login")
    public Object loginUser(User user) {
        Map<String,Object> result = new HashMap<String, Object>();
        System.err.println(user);
        System.out.println(user.getPwd()+","+user.getUserName());
        if("admin".equals(user.getUserName()) && "123456".equals(user.getPwd())) {
            result.put("code", 200);
            result.put("msg", "登录成功");
            result.put("token", "adminxxxx");
            return result;
        }
        
        result.put("code", 500);
        result.put("msg", "登录失败");
        return result;
    }
    
    @PostMapping("/submit")
    public Object submitUser(User user) {
        
        Map<String,Object> result = new HashMap<String, Object>();
        if(StringUtils.isBlank(user.getId())) {
            user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            userService.save(user);
        }else{
            userService.update(user);
        }

        
        result.put("success", true);
        result.put("msg", "登录成功");
        result.put("token", "adminxxxx");
        return result;
    }
    @PostMapping("/userlist")
    public List<User> userList(String filter){
    	Map<String,Object> map = new HashMap<>();
        return userService.listUser(map);
    }
    
    @PostMapping("/delete")
    public Map<String, Object> delete(String userId){
        Map<String,Object> result = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(userId)) {
            userService.deleteByPrimarykey(userId);
            result.put("success", true);
        }else {
            result.put("success", false);
        }
        return result;
    }
    
}