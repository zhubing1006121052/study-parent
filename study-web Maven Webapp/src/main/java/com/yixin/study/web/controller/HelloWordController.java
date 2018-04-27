package com.yixin.study.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yixin.study.model.vo.CustomerVo;

@Controller
@RequestMapping("/demo")
public class HelloWordController {

	private static final Logger log = LoggerFactory.getLogger(HelloWordController.class);
	
	@RequestMapping(value = "/helloword/{index}",method = RequestMethod.GET, produces = {
    "application/json; charset=utf-8" })
	@ResponseBody
	public Object helloword(@PathVariable Integer index){
		
		log.trace("");
		log.info("demo helloword"+index);
		int i = 1/index;
		if(index == 1){
			throw new IllegalArgumentException("非法参数");
		}
		CustomerVo customer = new CustomerVo();
		customer.setName("jack");
		log.debug("");
		return customer;
	}
	
	@RequestMapping(value = "/helloword/bean",method = RequestMethod.POST, produces = {
    "application/json; charset=utf-8" })
    @ResponseBody
    public Object hellowordBean(@RequestBody CustomerVo customer){
        
        
        return customer;
    }
}

