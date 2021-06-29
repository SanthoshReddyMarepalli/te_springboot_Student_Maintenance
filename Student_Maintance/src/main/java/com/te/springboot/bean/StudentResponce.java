package com.te.springboot.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonPropertyOrder({ "status", "msg" })
@JsonRootName("student_responce")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponce {

	private int status;

	private String msg;

	private String description;

	@JsonProperty("student_info")
	private StudentBean studentBean;
	@JsonProperty("student_details")
	private List<StudentBean> bean;
}
