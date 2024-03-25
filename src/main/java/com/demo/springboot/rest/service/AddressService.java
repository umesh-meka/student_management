package com.demo.springboot.rest.service;

import java.util.List;

import com.demo.springboot.rest.entity.Address;

// dont use @Servie on interface as we cant create the instances
// @Service
public interface AddressService {

	List<Address> getAllAddresses();

	Address save(Address address);

	Address getAddressById(Long id);
}
