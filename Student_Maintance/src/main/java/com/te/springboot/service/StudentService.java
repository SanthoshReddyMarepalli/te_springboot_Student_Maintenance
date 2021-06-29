package com.te.springboot.service;

import java.util.List;

import com.te.springboot.bean.StudentBean;

public interface StudentService {
	
	public StudentBean getStudent(int user_id);

	public boolean deleteStudent(int user_id);

	public List<StudentBean> getAllStudents();

	public boolean addStudent(StudentBean bean);

	public boolean updateStudent(StudentBean bean);

}
