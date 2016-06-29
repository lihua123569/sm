package com.sina.user.model;

import com.common.generic.GenericEntity;;
/** (USER) **/
public class User extends GenericEntity  {

	private static final long serialVersionUID = 1L;
	
	/**/
	private String userid;
	/**/
	public String getUserid(){
		return userid;
	}
	
	public void setUserid(String userid){
		 this.userid= userid;
	}
	
	/*  */
	private String username;
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username= username;
	}
	/*  */
	private String password;
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password= password;
	}
	/*  */
	private String phone;
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone= phone;
	}
	/*  */
	private String gender;
	
	 
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private String agree;
	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}
	
		
}