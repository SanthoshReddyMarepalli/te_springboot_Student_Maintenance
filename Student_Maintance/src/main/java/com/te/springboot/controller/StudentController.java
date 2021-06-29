package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.StudentBean;
import com.te.springboot.bean.StudentResponce;
import com.te.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping(path = "/getStudent", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce getEmp(Integer user_id) {

		StudentResponce responce = new StudentResponce();
		StudentBean studentBean = service.getStudent(user_id);
		if (studentBean != null) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Student detailes found for id :" + user_id);
			responce.setStudentBean(studentBean);
		} else {
			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("Student detailes not found for id :" + user_id);

		}
		return responce;

	}// End of getStudent method

	@GetMapping(path = "/getAllStudents", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce getAll() {
		StudentResponce responce = new StudentResponce();
		List<StudentBean> bean = service.getAllStudents();
		if (bean != null) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Students detailes found");
			responce.setBean(bean);

		} else {
			responce.setStatus(404);
			responce.setMsg("error");
			responce.setDescription("Students detailes not found");

		}

		return responce;

	}// End of getAll method

	@PutMapping(path = "/updateStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponce update(@RequestBody StudentBean bean) {

		StudentResponce responce = new StudentResponce();
		if (service.updateStudent(bean)) {

			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Updated successfully");

		} else {
			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("Something went Wrong");

		}

		return responce;

	}// End of update method

	@PostMapping(path = "/addStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponce addEmp(@RequestBody StudentBean bean) {

		StudentResponce responce = new StudentResponce();
		if (service.addStudent(bean)) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Added successfully");

		} else {
			responce.setStatus(404);
			responce.setMsg("Failure");
			responce.setDescription("Something went wrong");
		}

		return responce;

	}// End of addStudent method

	@DeleteMapping(path = "/deleteStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE  })
	public StudentResponce deleteEmp(int user_id) {
		StudentResponce responce = new StudentResponce();
		if (service.deleteStudent(user_id)) {
			responce.setStatus(200);
			responce.setMsg("success");
			responce.setDescription("Deleted successfully");

		} else {
			responce.setStatus(404);
			responce.setMsg("failure");
			responce.setDescription("something went wrong");

		}
		return responce;

	}// End of deleteStudent method
}
