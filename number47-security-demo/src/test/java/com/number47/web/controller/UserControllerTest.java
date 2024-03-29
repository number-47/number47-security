package com.number47.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author number47
 * @date 2019/8/3 20:54
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;
	/**
	 * 模拟MVC环境
	 */
	private MockMvc mockMvc;

	/**
	 * 每次测试用例执行之前执行
	 */
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void whenQuerySuccess() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/user") //get请求
						.param("userName","JOJO")
						.contentType(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(MockMvcResultMatchers.status().isOk()) //状态码200
						.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))//返回集合长度为3
						.andReturn().getResponse().getContentAsString();

		System.out.println(result);
	}

	@Test
	public void whenGetInfoSuccess() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1") //get请求
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk()) //状态码200
				.andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("JOJO"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}

	@Test
	public void whenGetInfoFail() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/user/a") //get请求
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError()); //状态码400
	}

	@Test
	public void whenCreateSuccess() throws Exception{
		Date date = new Date();
		System.out.println(date.getTime());
		String content = "{\"userName\":\"JOJO\",\"password\":null,\"birthDay\":"+date.getTime()+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/user") //get请求
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
				.andExpect(MockMvcResultMatchers.status().isOk()) //状态码200
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);

	}

	@Test
	public void whenUpdateSuccess() throws Exception{
		Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).getYear());
		System.out.println(date.getTime());
		String content = "{\"userName\":\"JOJO\",\"password\":null,\"birthDay\":"+date.getTime()+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.put("/user/1") //get请求
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
				.andExpect(MockMvcResultMatchers.status().isOk()) //状态码200
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);

	}

	@Test
	public void whenDeleteSuccess() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/1") //get请求
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk()); //状态码200
	}
}
