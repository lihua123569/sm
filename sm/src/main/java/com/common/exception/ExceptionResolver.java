package com.common.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
/**
 * 框架统一异常处理器
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 * @author 徐攀
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);
    
    @Override
    public ModelAndView resolveException (HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        
        String code = "";
        
        String message = "";
        //已知异常处理
        if (ex instanceof AppException) {
            
            AppException appException = (AppException) ex;
            
            code = appException.getCode();
            
            message = appException.getErrorMessage();
            
            LOGGER.info("AppException occoured,code:{},message:{}",code,message);
            
        }else {//未知异常处理
            
            LOGGER.info("unknown exception occoured");
            
            LOGGER.error("unknown exception occoured",ex);
            
            code = "9999";
            
            message = "服务器繁忙，请稍后再试~";
        }
        
        processResponse(response, code, message);
        
        return null;
    }
    /**
     * 处理ajax的返回结果
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void processResponse(HttpServletResponse response,String code,String message){
        
        response.setContentType("application/json; charset=utf-8");
        
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = null;
        
        try {
        	
        	JSONObject result = new JSONObject();
        	
        	result.put("responseCode", code);
        	
        	result.put("responseMsg", message);
            
            out = response.getWriter();
            
            out.write(result.toJSONString());
            
        } catch (IOException e) {
            
            LOGGER.info(" response write error");
            
            LOGGER.error("response write error",e);
            
        } finally {
            
            if (out!=null) {
                
                out.close();
            }
        }
    }
}
