package com.number47;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

/**
 * @author number47
 * @date 2019/8/3 20:26
 * @description
 */
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
	}

	@GetMapping("hello")
	public String hello(){
		return "hello spring security";
	}

}
