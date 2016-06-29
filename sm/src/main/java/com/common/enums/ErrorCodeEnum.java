/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: ErrorCodeEnum.java
 * Author:   14031966
 * Date:     2015年11月25日 下午4:22:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.common.enums;

/**
 * 支付系统号段7001-7500<br> 
 * 〈功能详细描述〉
 *
 * @author xupan
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum ErrorCodeEnum {
	
	 
	/**
	 * 用户注册失败
	 */
	USER_REGIST_FAIL("1004","用户注册失败"),
	/**
	 * 手机号已存在
	 */
	USER_PHONE_EXSIT("1003","手机号已存在,请从新输入"),
	/**
	 * 用户名不存在
	 */
	USER_NOT_EXSIT("1002","用户名不存在"),
	/**
	 * 用户名或密码错误
	 */
	USER_USERNAME_PASSWORD_ERROR("1001","用户名或密码错误"),
	/**
     * 查询结果为空
     */
    QUERY_NO_RESULT("9997","查询结果为空"),
    /**
     * 参数非法
     */
    ILLEGAL_ARGUMENT("9998","参数非法"),
    /**
     * 日期格式转换异常
     */
    DATE_PARSE_EXCEPTION("ERROR9997","日期格式转换异常"),
    /**
     * 成功
     */
    SUCCESS("0000","success"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("9999","系统异常");
    /**
     * 响应码
     */
    private String code;
    /**
     * 描述
     */
    private String description;
    /**
     * 私有构造函数
     * 
     * @param code
     * @param description
     */
    private ErrorCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
