package com.yixin.study.rpc.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

	public static void main(String[] args) throws InterruptedException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"META-INF/demo/dubbo-demo-consumer.xml"});
        context.start();
        //com.yixin.study.rpc.demo.ServiceTest@2fb0623e
        ServiceTest serviceTest = (ServiceTest) context.getBean("serviceTest");
        // obtain proxy object for remote invocation  和上面对比可以明显看出来下面不是DemoService类自己的对象而是代理对象
        //com.yixin.study.rpc.demo.proxy0@75f5fd58
        DemoService demoService = (DemoService) context.getBean("demoService");
        for(int i=0;i<1000;i++){
//        	throw new RuntimeException();
        	// execute remote invocation
            String hello = demoService.sayHello("world");
            // show the result
            System.out.println("accept "+hello+" from server.");
        }
        

	}

}

