package com.yixin.study.service.service;

import com.github.pagehelper.PageInfo;
import com.yixin.study.model.entity.Customer;

public interface CustomerService {

	/**
	 * 
	 * 
	 * @param customer
	 * @return 
	 * @author YixinCapital -- zhubing
	 *	       2018年3月5日 上午11:22:32
	 */
	PageInfo<Customer> getCustomersWithPage(Customer customer);
}

