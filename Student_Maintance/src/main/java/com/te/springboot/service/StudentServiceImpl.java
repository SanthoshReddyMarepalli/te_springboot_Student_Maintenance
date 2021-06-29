package com.te.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.bean.StudentBean;
import com.te.springboot.dao.StudentDAO;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO dao;
	@Override
	public StudentBean getStudent(int user_id) {
		
		return dao.getStudent(user_id);
	}

	@Override
	public boolean deleteStudent(int user_id) {
		return dao.deleteStudent(user_id);
	}

	@Override
	public List<StudentBean> getAllStudents() {
		return dao.getAllStudents();
	}

	@Override
	public boolean addStudent(StudentBean bean) {
		return dao.addStudent(bean);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		return dao.updateStudent(bean);
	}

}
