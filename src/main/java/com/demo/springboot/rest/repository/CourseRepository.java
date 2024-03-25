package com.demo.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.rest.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
