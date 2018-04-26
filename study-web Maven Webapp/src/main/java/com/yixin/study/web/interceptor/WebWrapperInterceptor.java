package com.yixin.study.web.interceptor;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebWrapperInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(WebWrapperInterceptor.class);
    
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    /**
     * Handler执行之前调用这个方法 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 打印请求参数
        startTime.set(new Date().getTime());
        return true;
    }
    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法,如果是返回@responseBody那么在调用这个方法之前已经返回json了
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        System.out.println(handler);
        super.postHandle(request, response, handler, modelAndView);
    }
    /**
     * Handler执行完成之后调用这个方法 ，即在视图渲染完毕时回调
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("接口{}整个请求耗时：{}",request.getRequestURI(),(new Date().getTime() - startTime.get())/1000);
//        super.afterCompletion(request, response, handler, ex);
    }
}
