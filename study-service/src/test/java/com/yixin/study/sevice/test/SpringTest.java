package com.yixin.study.sevice.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.yixin.study.dao.dao.CustomerMapper;
import com.yixin.study.model.entity.Customer;
import com.yixin.study.model.entity.CustomerExample;
import com.yixin.study.service.service.CustomerService;
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试 
//@WebAppConfiguration
@ContextConfiguration({"classpath:META-INF/spring/spring-application.xml"})
public class SpringTest {
	

	@Autowired
	CustomerMapper customerMapper;
	@Autowired
	CustomerService customerService;
	
	@Test
	public void jtest_save(){
		
		
		Customer record = new Customer(); 
		record.setUserId("34230043753497521");
		record.setUserName("小明3");
		record.setAddress("alix");
		Byte vip = 0;
		record.setVip(vip);
		record.setAge(12);
		customerMapper.insert(record);
	}
	
	@Test
	public void jtest_select(){
		
		Customer customer = new Customer(); 
		customer.setCurrentPage(1);
		customer.setPageSize(2);
		customer.setAddress("ssp");
		PageInfo<Customer> customersWithPage = customerService.getCustomersWithPage(customer);
		System.out.println(customersWithPage);
		
	}
	@Test
	public void test_select_between(){
		
		CustomerExample example = new CustomerExample(); 
		example.createCriteria().andAddressBetween("SSP", "ssp");
		List<Customer> selectByExample = customerMapper.selectByExample(example);
		System.out.println(selectByExample);
	}
	@Test
	public void test_select_in(){
		/**
		 * 可以把两个库中的所有数据全部查询出来
		 */
		CustomerExample example = new CustomerExample(); 
		List<String> values = new ArrayList<String>(); 
		values.add("alix");
		values.add("ssp");
		values.add("b");
		example.createCriteria().andAddressIn(values);
		List<Customer> selectByExample = customerMapper.selectByExample(example);
		System.out.println(selectByExample);
	}
	
	@Test
	public void test_select_great(){
		
		//分片策略灵活，可支持=，BETWEEN，IN等多维度分片，也可支持多分片键共用。
		CustomerExample example = new CustomerExample(); 
		example.createCriteria().andAddressGreaterThan("ssp");
		List<Customer> selectByExample = customerMapper.selectByExample(example);
		System.out.println(selectByExample);
	}
}
interface A {
	int x=0;
}
class B implements A{
	int x = 1;
}

