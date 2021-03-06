package com.dxc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.student.entities.StudentManagement;
import com.dxc.student.service.IStudentService;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping(path = "/insert-student", consumes = { "application/json" })
	public StudentManagement insertStudentDetails(@RequestBody StudentManagement studentManagement) {
		return studentService.insertStudentDetails(studentManagement);
	}

	@PutMapping(path = "/update-student/{studentId}", consumes = { "application/json" })
	public StudentManagement updateStudentDetails(@RequestBody StudentManagement studentManagement,
			@PathVariable("studentId") long studentId) {
		return studentService.updateStudentDetails(studentManagement, studentId);
	}

	@DeleteMapping(path = "/delete-student/{studentId}")
	public ResponseEntity<?> deleteStudentDetails(@PathVariable("studentId") long studentId) {
		return studentService.deleteStudentDetails(studentId);
	}

	@GetMapping(path = "/get-student/{studentId}", produces = { "application/json" })
	public StudentManagement getStudentById(@PathVariable("studentId") long studentId) {
		return studentService.getStudentById(studentId);
	}

	@GetMapping(path = "/show-all", produces = { "application/json" })
	public List<StudentManagement> getAllStudents() {
		return studentService.getAllStudents();
	}

}
