package com.demo.springboot.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.rest.entity.Address;
import com.demo.springboot.rest.exception.StudentIDNotFoundException;
import com.demo.springboot.rest.repository.AddressRepository;
import com.demo.springboot.rest.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address getAddressById(Long id) {
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new StudentIDNotFoundException("Address record not found", 707L);
		}
	}
}
