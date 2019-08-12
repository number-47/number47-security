package com.number47.com.number47.vaildator;

import com.number47.com.number47.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author number47
 * @date 2019/8/3 23:02
 * @description
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

	@Autowired
	private HelloService helloService;

	/**
	 * 初始化
	 * @param myConstraint
	 */
	@Override
	public void initialize(MyConstraint myConstraint) {
		System.out.println("my validator init");
	}

	/**
	 * 校验
	 * @param value
	 * @param constraintValidatorContext
	 * @return
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
		helloService.greeting("JOJO validator");
		System.out.println(value);
		return false;
	}
}
