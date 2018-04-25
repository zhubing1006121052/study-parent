package com.yixin.study.rpc.doself.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.yixin.study.rpc.doself.server.register.Server;
import com.yixin.study.rpc.doself.server.register.ServiceCenter;
import com.yixin.study.rpc.doself.server.services.HelloService;
import com.yixin.study.rpc.doself.server.services.HelloServiceImpl;

public class RPCTest {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {  
            public void run() {  
                try { 
                	//启动服务端
                    Server serviceServer = new ServiceCenter(8123);  
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);  
                    serviceServer.start();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }).start();  
        HelloService service = RPCClient  
                .getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8123));  
        System.out.println(service.sayHi("test")); 

	}

}

