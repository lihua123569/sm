package com.sina.wall.model;

import com.common.generic.GenericEntity;;
/** (WALL_PIC) **/
public class WallPic extends GenericEntity  {

	private static final long serialVersionUID = 1L;
	
	/*瀑布流图片id*/
	private String id;
	/*瀑布流图片id*/
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		 this.id= id;
	}
	
	/* 图片地址 */
	private String url;
	
	public String getUrl(){
		return url;
	}
	
	public void setUrl(String url){
		this.url= url;
	}
	/* 图片标题 */
	private String title;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title= title;
	}

		
}