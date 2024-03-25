package com.demo.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.rest.entity.Address;
import com.demo.springboot.rest.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Address>> getAllAddresses() {
		System.out.println("Inside getAllAddresses() of AddressController ");
		List<Address> list = addressService.getAllAddresses();
		return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Address> save(@RequestBody Address address) {
		System.out.println("Inside save() of AddressController ");
		Address add = addressService.save(address);
		return new ResponseEntity<Address>(add, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable Long id) {
		System.out.println("Inside getAddressById() of AddressController ");
		Address add = addressService.getAddressById(id);
		return new ResponseEntity<Address>(add, HttpStatus.OK);
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
//		System.out.println("Inside deleteStudentById() of controller ");
//		studentService.deleteStudentById(id);
//		return new ResponseEntity<String>("Student has been deleted successfully", HttpStatus.OK);
//	}
//	
//	@Tag(name = "put", description = "PUT methods of Student APIs")
//	@PutMapping("/")
//	public ResponseEntity<Student> update(@RequestBody Student student) {
//		System.out.println("Inside update() of controller ");
//		Student std = studentService.update(student);
//		return new ResponseEntity<Student>(std, HttpStatus.OK);
//	}
//	
//	@Tag(name = "patch", description = "PATCH methods of Student APIs")
//	@PatchMapping("/")
//	public ResponseEntity<Student> patchUpdate(@RequestBody Student student) {
//		System.out.println("Inside patchUpdate() of controller, ");
//		Student std = studentService.patchUpdate(student);
//		return new ResponseEntity<Student>(std, HttpStatus.OK);
//	}

}
