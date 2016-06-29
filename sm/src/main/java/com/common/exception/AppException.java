/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: AppException.java
 * Author:   14031966
 * Date:     2015年11月25日 下午4:20:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.common.exception;

import com.common.enums.ErrorCodeEnum;

/**
 * 业务异常<br> 
 * 〈功能详细描述〉
 *
 * @author 14031966
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AppException extends RuntimeException {

    /**
     */
    private static final long serialVersionUID = -45950644483715464L;
    
    
    private String code;
    
    /**
     * 错误信息
     */
    private String errorMessage;
    
    public AppException(ErrorCodeEnum ErrorCodeEnum){
        
        super(ErrorCodeEnum.getCode()+":"+ErrorCodeEnum.getDescription());
        
        this.code = ErrorCodeEnum.getCode();
        
        this.errorMessage = ErrorCodeEnum.getDescription();
    }
    
    
    public AppException(ErrorCodeEnum ErrorCodeEnum,String description){
        
        super(description);
        
        this.code = ErrorCodeEnum.getCode();
        
    }
    
    
    
    public String getCode() {
        return code;
    }
    
    
    
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }


	public String getErrorMessage() {
		return errorMessage;
	}

}
