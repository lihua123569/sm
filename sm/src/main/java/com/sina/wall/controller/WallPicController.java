package com.sina.wall.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.utils.ResultHandle;
import com.sina.user.controller.UserController;
import com.sina.wall.model.WallPic;
import com.sina.wall.service.WallPicService;

@Controller
@RequestMapping(value="wall")
public class WallPicController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private WallPicService wallPicService;
	
	@RequestMapping(value="getWallPics")
	@ResponseBody
	private String  queryWallPicList(){
		WallPic wallPic = new WallPic();
		List<WallPic> wallPicList = wallPicService.selectByEntityWhere(wallPic);
		Map<String, Object> resMap = ResultHandle.success();
		resMap.put("walls", wallPicList);
		log.info("exit queryWallPicList, wallPicList:{}"+wallPicList);
		return JSON.toJSONString(resMap);
	}
	
}
