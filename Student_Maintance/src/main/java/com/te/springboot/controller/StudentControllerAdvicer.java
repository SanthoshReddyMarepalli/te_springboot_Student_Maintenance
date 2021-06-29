package com.te.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springboot.bean.StudentResponce;
import com.te.springboot.exception.StudentException;
@RestControllerAdvice
public class StudentControllerAdvicer {

	@ExceptionHandler(StudentException.class)
	public StudentResponce handler(StudentException expception) {

		StudentResponce responce = new StudentResponce();

		responce.setStatus(500);
		responce.setMsg(expception.getMessage());
		responce.setDescription(expception.getMessage());

		return responce;

	}

}
