package com.github.sarojmandal.jpahibernate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.sarojmandal.jpahibernate.entity.Course;

public interface CourseDataRepository extends JpaRepository<Course, Integer> {

	public Optional<Course> queryByName(String name);

	@Query(value = "select c from Course c where name like '%React%'")
	public List<Course> queryByNameLike();
}