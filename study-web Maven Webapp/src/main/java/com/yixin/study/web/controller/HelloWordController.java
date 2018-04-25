package com.yixin.study.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class HelloWordController {

	private static final Logger log = LoggerFactory.getLogger(HelloWordController.class);
	
	@RequestMapping(value = "/helloword/{index}",method = RequestMethod.GET)
	@ResponseBody
	public String helloword(@PathVariable Integer index){
		
		log.trace("");
		log.info("demo helloword"+index);
		int i = 1/index;
		if(index == 1){
			throw new IllegalArgumentException("非法参数");
		}
		log.debug("");
		return "{name:'helloword'}";
	}
}

