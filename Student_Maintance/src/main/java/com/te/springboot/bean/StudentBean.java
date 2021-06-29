package com.te.springboot.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name="student_info")
@JsonPropertyOrder({ "user_id", "name" })
@JsonRootName("student-info")
@XmlRootElement(name="student-info")
public class StudentBean implements Serializable{

	@Id
	@Column
	@JsonProperty("user_id")
	private Integer user_id;
	
	@Column
	private String email;
	
	@Column
	private Double marks;
	
	@Column
	private String name;
	
	@Column
	private String grade;
}
