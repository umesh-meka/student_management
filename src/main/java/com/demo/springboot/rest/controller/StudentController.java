package com.demo.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.rest.entity.Student;
import com.demo.springboot.rest.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	// @Autowired works only for classes not interfaces
	// @Autowired
	// private StudentService studentService;
	
	// now this works as we have added the 
	@Autowired
	private StudentService studentService;
	
	// Ambiguous mapping. Cannot map 'simpleRestAPI' method 
	// if we same context path for two method handlers
	// @GetMapping("/")
	
	@Tag(name = "get", description = "GET methods of Student APIs")
	@GetMapping("/")
	public List<Student> getAllStudents() {
		System.out.println("Inside getAllStudents() of StudentController ");
		return studentService.getAllStudents();
	}
	
	@Tag(name = "get", description = "GET methods of Student APIs")
	@GetMapping("/findAll")
	public ResponseEntity<List<Student>> findAllStudents() {
		System.out.println("Inside findAllStudents() of StudentController ");
		List<Student> list = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@Tag(name = "post", description = "POST methods of Student APIs")
	@PostMapping("/")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		System.out.println("Inside save() of StudentController ");
		Student std = studentService.save(student);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	}
	
	@Tag(name = "get", description = "GET methods of Student APIs")
	@Operation(summary = "returns a student",
    			description = "Returns a existing student. The response is updated with Student object with id, first name, and last name.")
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@Parameter(
		       description = "ID of student to be retrieved",
		       required = true)
				@PathVariable Long id) {
		System.out.println("Inside getStudentById() of StudentController ");
		Student std = studentService.getStudentById(id);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	}
	
//	public ResponseEntity<?> getStudentById(@Parameter(
//		       description = "ID of student to be retrieved",
//		       required = true)
//				@PathVariable Long id) {
//		System.out.println("Inside getStudentById() of controller ");
//		Student std = null;
//		try {
//			std = studentService.getStudentById(id);
//		} catch (StudentIDNotFoundException e) {
//			System.out.println("check 3");
//			return new ResponseEntity<StudentIDNotFoundException>(new StudentIDNotFoundException(e.getErrorMessage(), 
//					e.getErrorCode()), 
//					HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<Student>(std, HttpStatus.OK);
//	}
	
	@Tag(name = "delete", description = "DELETE methods of Student APIs")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
		System.out.println("Inside deleteStudentById() of StudentController ");
		studentService.deleteStudentById(id);
		return new ResponseEntity<String>("Student has been deleted successfully", HttpStatus.OK);
	}
	
	@Tag(name = "put", description = "PUT methods of Student APIs")
	@PutMapping("/")
	public ResponseEntity<Student> update(@RequestBody Student student) {
		System.out.println("Inside update() of StudentController ");
		Student std = studentService.update(student);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	}
	
	@Tag(name = "patch", description = "PATCH methods of Student APIs")
	@PatchMapping("/")
	public ResponseEntity<Student> patchUpdate(@RequestBody Student student) {
		System.out.println("Inside patchUpdate() of StudentController ");
		Student std = studentService.patchUpdate(student);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	}

}
