package com.demo.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.rest.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
