package com.yixin.study.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Component("resultWrapperAop")
//@Aspect
public class ResultWrapperAop {
    
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public  void resultWrapperAop() {} 
    
    @Around("controllerAspect()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        Object proceed = pjp.proceed();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "0000");
        map.put("message", "成功");
        map.put("data", proceed);
    }
}
