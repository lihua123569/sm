package com.sina.user.service;

import java.util.List;

import com.common.generic.GenericService;
import com.sina.modelrequest.UserRequest;
import com.sina.modelresponse.UserResponse;
import com.sina.user.model.User;

public interface UserService extends GenericService<User, String> {
 
	public UserResponse  queryUserByUserid(String userid);
	
	public List<UserResponse> queryUserListByParams(UserRequest urequest);
	
	public List<User> queryUserList(User user);
    
	public boolean isUserExist(String username);
	public boolean validateLogin(UserRequest user);
	public boolean isPhoneExist(String phone);
	
	public boolean save(User user);
}