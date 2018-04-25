package com.yixin.study.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixin.study.dao.dao.CustomerMapper;
import com.yixin.study.model.entity.Customer;
import com.yixin.study.model.entity.CustomerExample;
import com.yixin.study.service.service.CustomerService;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerMapper customerMapper;
	
	public PageInfo<Customer> getCustomersWithPage(Customer customer) {
		
		Integer pageSize = customer.getPageSize();
		Integer currentPage = customer.getCurrentPage();
		CustomerExample example = new CustomerExample();
		
		example.createCriteria().andAddressEqualTo(customer.getAddress());
		

        int cnt = customerMapper.countByExample(example);
        
        /*分页信息*/
        PageHelper.startPage(currentPage,pageSize);
		List<Customer> custs = customerMapper.selectByExample(example);
		
		PageInfo<Customer> page = new PageInfo<Customer>(custs);
		page.setPageNum(currentPage);
		page.setPages(pageSize);
		page.setTotal(0);
		return page;
	}

}

