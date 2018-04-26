package com.yixin.study.model.vo;

import com.yixin.study.model.enm.SystemRetnStatus;

public class SystemResult {

    private String code;
    private String message;
    
    private Object data;
    
    public SystemResult(){}
    
    
    public SystemResult(SystemRetnStatus status,Object data){
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
}
