package com.number47.com.number47.service.impl;

import com.number47.com.number47.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author number47
 * @date 2019/8/3 23:06
 * @description
 */
@Service
public class HelloServiceImpl implements HelloService {

	public String greeting(String name){
		System.out.println("greeting");
		return "hello" + name;
	}
}
