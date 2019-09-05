package com.github.sarojmandal.jpahibernate.repository;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.sarojmandal.jpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CourseDataRepositoryTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	CourseDataRepository courseRepository;

	@Test
	public void find_by_id() {
		Optional<Course> courseOpt = courseRepository.findById(100001);
		logger.info("Course => {}", courseOpt.get());
	}

	@Test
	public void find_by_name() {
		Optional<Course> courseOpt = courseRepository.queryByName("Spring boot jpa hibernate");
		logger.info("Course => {}", courseOpt.get());
	}

	@Test
	public void find_All_order_by_name() {
		Sort sortbyName = new Sort(Direction.DESC, "name");
		List<Course> allCourse = courseRepository.findAll(sortbyName);
		logger.info("Course => {}", allCourse);
	}

	@Test
	public void find_All_order_by_name_paginated() {
		Sort sortbyName = new Sort(Direction.DESC, "name");
		PageRequest pageReq = PageRequest.of(0, 1, sortbyName);
		Page<Course> coursePage = courseRepository.findAll(pageReq);
		logger.info("CoursePage => {}", coursePage);
		logger.info("Course => {}", coursePage.getContent());
		Page<Course> secondPage = courseRepository.findAll(coursePage.nextPageable());
		logger.info("CoursePage => {}", secondPage);
		logger.info("Course => {}", secondPage.getContent());

	}

	@Test
	public void find_All_course_name_like_React() {
		List<Course> allCourse = courseRepository.queryByNameLike();
		logger.info("Course => {}", allCourse);
	}

}
