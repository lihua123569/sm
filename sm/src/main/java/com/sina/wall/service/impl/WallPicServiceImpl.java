package com.sina.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.generic.GenericDao;
import com.common.generic.GenericServiceImpl;
import com.sina.wall.dao.WallPicDao;
import com.sina.wall.model.WallPic;
import com.sina.wall.service.WallPicService;

@Service
public class WallPicServiceImpl extends GenericServiceImpl<WallPic, String> implements
		WallPicService {

	@Autowired
	WallPicDao wallPicDao;

	
	@Override
	public GenericDao<WallPic, String> getDao() {
		return wallPicDao;
	}

	
	

}