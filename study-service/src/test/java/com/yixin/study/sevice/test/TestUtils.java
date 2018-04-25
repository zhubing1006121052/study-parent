package com.yixin.study.sevice.test;

public class TestUtils {

	public static void main(String[] args) {
		
		TestUtils a = new TestUtils();
		a.test1();
	}

	public static synchronized void test1(){
		System.out.println("test1");
		test2();
	}
	
	public static synchronized void test2(){
		System.out.println("test2");
	} 
}

