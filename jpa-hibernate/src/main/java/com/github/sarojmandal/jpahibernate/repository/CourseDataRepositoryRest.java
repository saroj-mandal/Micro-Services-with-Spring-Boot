package com.github.sarojmandal.jpahibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.sarojmandal.jpahibernate.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseDataRepositoryRest extends JpaRepository<Course, Integer> {

}