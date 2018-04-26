package com.yixin.study.web.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice
 * @ExceptionHandler 这两个注解组合使用使所有没有捕获的异常在此捕获统一处理
 * Package : com.yixin.study.web.exception
 * 
 * @author YixinCapital -- zhubing
 *		   2018年3月2日 上午11:01:25
 *
 */
//@ControllerAdvice
public class GlobalExceptionHandle {

	Logger logger = Logger.getLogger(GlobalExceptionHandle.class);
	
//	@ExceptionHandler  
	public void exceptionHandle(HttpServletRequest request,HttpServletResponse response, Exception ex){
		
		ex.printStackTrace();
		logger.error("异常统一处理", ex);
		String json= "服务器异常";
		writeJson(json,response);
	}
	
	/**
	 * 如果是指定异常则会走这  其他 未知异常会走上面
	 * 
	 * @param response
	 * @param iceptn 
	 * @author YixinCapital -- zhubing
	 *	       2018年3月2日 上午11:33:44
	 */
//	@ExceptionHandler(value = IllegalArgumentException.class)
	public void illgeArgs(HttpServletResponse response, IllegalArgumentException iceptn){
		logger.error("特定异常处理", iceptn);
		String json= "非法参数";
		writeJson(json,response);
	}
	
	
	public void writeJson(String str, HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
		    out = response.getWriter();
		    out.write(str);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
	}
}

