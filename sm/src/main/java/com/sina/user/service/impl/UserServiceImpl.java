package com.sina.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.common.enums.ErrorCodeEnum;
import com.common.generic.GenericDao;
import com.common.generic.GenericServiceImpl;
import com.common.utils.AssertUtils;
import com.sina.modelrequest.UserRequest;
import com.sina.modelresponse.UserResponse;
import com.sina.user.dao.UserDao;
import com.sina.user.model.User;
import com.sina.user.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements
		UserService {

	@Autowired
	UserDao userDao;

	
	@Override
	public GenericDao<User, String> getDao() {
		return userDao;
	}


	@Override
	public UserResponse queryUserByUserid(String userid) {
		User user = userDao.selectByPrimaryKey(userid);
		AssertUtils.isNotNull(user, ErrorCodeEnum.QUERY_NO_RESULT);
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(user, userResponse); 
		return userResponse;
	}


	@Override
	public List<UserResponse> queryUserListByParams(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isUserExist(String username) {
		User user = new User();
		user.setUsername(username);
		AssertUtils.isTrue(userDao.selectByEntityWhere(user).size()>0, ErrorCodeEnum.USER_NOT_EXSIT);
		return true;
	}


	@Override
	public boolean validateLogin(UserRequest urequest) {
		User user = new User();
		BeanUtils.copyProperties(urequest, user); 
		AssertUtils.isTrue(userDao.selectByEntityWhere(user).size()>0, ErrorCodeEnum.USER_USERNAME_PASSWORD_ERROR);
		return true;
	}


	@Override
	public boolean isPhoneExist(String phone) {
		User user = new User();
		user.setPhone(phone);
		AssertUtils.isTrue(userDao.selectByEntityWhere(user).size()<=0, ErrorCodeEnum.USER_PHONE_EXSIT);
		return true;
	}


	@Override
	public boolean save(User user) {
		user.setUserid(UUID.randomUUID().toString());
		int i = userDao.insert(user);
		AssertUtils.isTrue(i==1, ErrorCodeEnum.USER_REGIST_FAIL);
		return true;
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString()+"="+UUID.randomUUID().toString().length());
	}


	@Override
	public List<User> queryUserList(User user) {
		return userDao.selectByEntityWhere(user);
	}
	

}