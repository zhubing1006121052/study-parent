package com.yixin.study.rpc.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.web.JsonPath;

public class Provider {
	
	public static int a[] = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws IOException {
		
//		sysout_tree(2);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"META-INF/demo/dubbo-demo-provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();

	}
	/**
	 * 先序遍历：DLR
	 *  
	 * @author YixinCapital -- zhubing
	 *	       2018年3月17日 上午9:35:58
	 */ 
	public static void sysout_tree(int index){
		if(index > (a.length - 1) || index < 0)
			return;
		System.out.println(a[index]);
		sysout_tree(2*(index)+1);
		sysout_tree(2*(index+1));
	}

}
interface DemoService {
    String sayHello(String name);
}
class DemoServiceImpl implements DemoService {
	
	
    public DemoServiceImpl() {
		super();
	}

	public String sayHello(String name) {
		System.out.println("server is connected...");
		System.out.print("say hello to client");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "Hello ###### " + name;
    }
}

interface HelloWorldService {
    String sayHelloWorld(String name);
    
    void acceptMessage(String msg);
}
class HelloWorldServiceImpl implements HelloWorldService {
	
    public HelloWorldServiceImpl() {
		super();
	}

	public String sayHelloWorld(String name) {
		System.out.println("server is connected...");
		System.out.print("say helloworld to client");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "helloworld " + name;
    }

	public void acceptMessage(String msg) {
		
		System.out.println("server get "+msg);
	}
}

class A{
	
	private static A a1 = new A();
	private static A a2 = null;
	private A(){}
	
	public static A getA1(){
		return a1;
	}
	
	public static A getA2(){
		synchronized(A.class){
			if(a2 == null){
				a2 = new A();
			}
			return a2;
		}
		
	}
}

