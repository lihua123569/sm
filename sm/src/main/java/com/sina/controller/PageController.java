package com.sina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.constants.PagePath;

@Controller
public class PageController {

	@RequestMapping(value="/user")
	public String user(){
		return PagePath.USER;
	}

	@RequestMapping(value="/login")
	public String login(){
		return PagePath.LOGIN;
	}

	@RequestMapping(value="/regist")
	public String regist(){
		return PagePath.REGIST;
	}
	
	@RequestMapping(value="/userList")
	public String userList(){
		return PagePath.USERLIST;
	}
	@RequestMapping(value="/bao")
	public String bao(){
		return PagePath.BAO;
	}
	@RequestMapping(value="/wall")
	public String wall(){
		return PagePath.WALL;
	}
	
	
	/*vue*/
	@RequestMapping(value="/vuedemo")
	public String vuedemo(){
		return PagePath.VUEDEMO;
	}
	@RequestMapping(value="/vuetab")
	public String vuetab(){
		return PagePath.VUETAB;
	}
	
	/*Bootstrap*/
	@RequestMapping(value="/bootstrap")
	public String bootstrap(){
		return PagePath.BOOTSTRAP;
	}
	@RequestMapping(value="/jinzhi")
	public String jinzhi(){
		return PagePath.JINZHI;
	}
}
