package com.demo.springboot.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String streetName;
	private String cityName;
	
//	Bi-directional (can save/read parent as well along while saving the child)
//	reference side generally links to the mapping created by owning side using mappedBy attribute
	@OneToOne(mappedBy = "address")
	private Student student;

}
