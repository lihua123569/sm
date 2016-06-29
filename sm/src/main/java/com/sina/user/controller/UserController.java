package com.sina.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.utils.ResultHandle;
import com.sina.modelrequest.UserRequest;
import com.sina.modelresponse.UserResponse;
import com.sina.user.model.User;
import com.sina.user.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUser")
	@ResponseBody
	public String getUsers(HttpServletRequest request,HttpServletResponse response, String str){
	
		log.info("enter getUsers: "+str);
		UserResponse users = userService.queryUserByUserid(str);
		
		Map<String, Object> resMap = ResultHandle.success();
		resMap.put("userInfo", users);
		log.info("enter getUsers: "+users.getUsername());
		return JSON.toJSONString(resMap);
	}
	
	@RequestMapping(value="/isUserExist")
	@ResponseBody
	public String isUserExist(HttpServletRequest request,HttpServletResponse response, User user){
		
		log.info("enter getUsers: "+user.getUsername()+user.getPassword()+user.getGender());
		Boolean booleans = userService.isUserExist(user.getUsername());
		
		Map<String, Object> resMap = ResultHandle.success();
		resMap.put("userInfo", booleans);
		log.info("enter getUsers: "+booleans);
		return JSON.toJSONString(resMap);
	}
	
	@RequestMapping(value="/regist",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String regist(HttpServletRequest request,HttpServletResponse response, User user){
		
		log.info("enter login user: "+user.getUsername()+user.getPassword()+user.getGender());
		userService.isPhoneExist(user.getPhone());
		userService.save(user);
		Map<String, Object> resMap = ResultHandle.success();
		resMap.put("loginInfo", "注册成功");
		log.info("enter exsit");
		return JSON.toJSONString(resMap);
	}
	
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response, UserRequest urequest){
		
		log.info("enter login user: "+urequest.getUsername()+urequest.getPassword()+urequest.getGender());
		Boolean isUserExist = userService.isUserExist(urequest.getUsername());
		Boolean booleans = userService.validateLogin(urequest);
		HttpSession session =request.getSession();
		session.setAttribute("rememberpwd", urequest.getUsername());
		session.setAttribute("automaticlogon", "1");//0 非自动登录,1 自动登录
		
		Map<String, Object> resMap = ResultHandle.success();
		resMap.put("loginInfo", "登录成功");
		log.info("enter 用户是否存在: "+isUserExist+"，用户名密码是否正确："+booleans);
		return JSON.toJSONString(resMap);
	}
	@RequestMapping(value="/queryUserList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryUserList(HttpServletRequest request,HttpServletResponse response, User user){
		
		log.info("enter login user: "+user.getUsername()+user.getPassword()+user.getGender());
		List<User> userList = userService.queryUserList(user);
		Map<String, Object> resMap = ResultHandle.success();
		resMap.put("userList", userList);
		log.info("enter exsit: "+userList);
		return JSON.toJSONString(resMap);
	}
	
}
