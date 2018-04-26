package com.yixin.study.web.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.alibaba.fastjson.JSON;
import com.yixin.study.model.enm.SystemRetnStatus;
import com.yixin.study.model.vo.SystemResult;


public class ResultWrapperAop  implements MethodInterceptor{

    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
        SystemResult sysRetn = null;
        Object data = null;
        try {
            data = invocation.proceed();
            sysRetn = new SystemResult(SystemRetnStatus.SYS_SUCCESS,data);
        } catch (Exception e) {
            sysRetn = new SystemResult(SystemRetnStatus.SYS_ERROR,data);
        }
        //这边必须转成JSONString,否则406 not acceptable
        return JSON.toJSONString(sysRetn);
    }

}
