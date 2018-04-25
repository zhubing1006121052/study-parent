package com.yixin.study.rpc.doself.server;

import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	public static void main(String[] args) {

		/*new Thread(new Runnable() {  
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
        }).start(); */
		/*HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("key", 18000000.00d);
		System.out.println(JSON.toJSONString(map));*/
		List<String> list  = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		for(String a : list){
			if(list.contains(a)){
				list.remove(a);
			}
		}
	}

}

