package com.demo.springboot.rest.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	// without atlease one @Id below is the error
	// Entity 'com.demo.springboot.rest.entity.Student' has no identifier 
	// (every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE
			)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Long contact;
	
//	Uni-directional (can save/read child as well along while saving the parent)
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn( name = "address_id", nullable = false,  updatable = false)
//	private Address address;
	
//	Bi-directional (can save child as well along while saving the parent)
//	owning side generally it defines the mapping using JoinColumn
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn( name = "address_id")
	private Address address;
	
//	Note: 
//	Entity having the @JoinColumn acts as parent and it will have the child primary key
//	generally owning side acts as parent as per current understanding
	
//	circular references, infinite recursion,
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private java.util.List<Course> course;
	
}
