package com.yixin.study.rpc.doself.server.services;

public class HelloServiceImpl implements HelloService {

	public String sayHi(String name) {  
        return "Hi, " + name;  
    } 

}

