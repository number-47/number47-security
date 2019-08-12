package com.number47.com.number47.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.number47.com.number47.dto.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author number47
 * @date 2019/8/3 21:08
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {


	@PostMapping
	@JsonView(User.UserSimpleView.class)
	public User userCreate(@Valid @RequestBody User user, BindingResult errors){
		//捕获没有通过校验的错误
		if (errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthDay());
		user.setId("1");
		return user;
	}

	@PutMapping("/{id:\\d+}")
	@JsonView(User.UserSimpleView.class)
	public User userUpdate(@Valid @RequestBody User user, BindingResult errors){
		//捕获没有通过校验的错误
		if (errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error -> {
//				FieldError fieldError = (FieldError) error;
//				String message = fieldError.getField() + " " + error.getDefaultMessage();
				System.out.println(error.getDefaultMessage());
			});
		}
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthDay());
		user.setId("1");
		return user;
	}

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(@RequestParam String userName){
		System.out.println(userName);
		List<User> users = new ArrayList<>(3);
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}

	/**
	 *
	 * @param userId 通过正则表达式 只能接受数字
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable(name = "id") String userId){
		User user = new User();
		user.setUserName("JOJO");
		return user;
	}

	@DeleteMapping("/{id:\\d+}")
	public void deleteUser(@PathVariable String id){
		System.out.println(id);
	}


}
