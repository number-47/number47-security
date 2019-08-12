package com.number47.com.number47.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.number47.com.number47.vaildator.MyConstraint;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author number47
 * @date 2019/8/3 21:12
 * @description
 */
public class User {

	public interface UserSimpleView{};

	public interface UserDetailView extends UserSimpleView{};

	private String id;

	@MyConstraint(message = "这是一个测试")
	private String userName;
	/**
	 * @NotBlank校验不为空
	 */
	@NotBlank(message = "密码不能为空")
	private String password;

	@Past(message = "生日日期必须为过去时间")
	private Date birthDay;

	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonView(UserSimpleView.class)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonView(UserSimpleView.class)
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
}
