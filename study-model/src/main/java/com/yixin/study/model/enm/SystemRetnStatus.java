package com.yixin.study.model.enm;

public enum SystemRetnStatus {

    SYS_SUCCESS("0000","成功"),
    
    SYS_ERROR("1000","失败");
    
    
    
    private String code;
    private String message;
    private SystemRetnStatus(String code, String message) {
        this.code = code;
        this.message = message;
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
    
}
