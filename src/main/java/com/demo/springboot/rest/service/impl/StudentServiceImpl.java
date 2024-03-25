package com.demo.springboot.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.rest.entity.Student;
import com.demo.springboot.rest.exception.StudentIDNotFoundException;
import com.demo.springboot.rest.repository.StudentRepository;
import com.demo.springboot.rest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id){
		// will get java.util.NoSuchElementException: No value present
		// if id is not present
		//return studentRepository.findById(id).get();
		
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new StudentIDNotFoundException("Hello", 707L);
		}
	}
	
//	public Student getStudentById(Long id) throws StudentIDNotFoundException {
//		// will get java.util.NoSuchElementException: No value present
//		// if id is not present
//		//return studentRepository.findById(id).get();
//		
//		Optional<Student> optional = studentRepository.findById(id);
//		System.out.println("check 1");
//		if(optional.isPresent()) {
//			System.out.println("check 2");
//			return optional.get();
//		} else {
//			System.out.println("check 2");
//			throw new StudentIDNotFoundException("Hello", 707L);
//		}
//	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student update(Student std) {
		Optional<Student> optional = studentRepository.findById(std.getId());
		
			return studentRepository.save(optional.get());
		
	}

	@Override
	public Student patchUpdate(Student std) {
		
		Optional<Student> optional = studentRepository.findById(std.getId());
		
		if(optional.isPresent()) {
			Student student = optional.get();
			
			if(std.getFirstName() != null)
				student.setFirstName(std.getFirstName());
			if(std.getLastName() != null)
				student.setLastName(std.getLastName());
			if(std.getContact() != null)
				student.setContact(std.getContact());
			
			return studentRepository.save(student);
		}
		
		return null;
	}

}
