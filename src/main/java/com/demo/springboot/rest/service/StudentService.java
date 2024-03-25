package com.demo.springboot.rest.service;

import java.util.List;

import com.demo.springboot.rest.entity.Student;

// dont use @Servie on interface as we cant create the instances
// @Service
public interface StudentService {

	List<Student> getAllStudents();

	Student save(Student student);

	Student getStudentById(Long id);
	//Student getStudentById(Long id) throws StudentIDNotFoundException;

	void deleteStudentById(Long id);

	Student update(Student student);

	Student patchUpdate(Student student);

}
