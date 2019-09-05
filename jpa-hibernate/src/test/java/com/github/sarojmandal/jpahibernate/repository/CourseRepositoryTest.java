package com.github.sarojmandal.jpahibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.sarojmandal.jpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void find_by_id() {
		Course course = courseRepository.findById(100001);
		assertEquals("Spring boot jpa hibernate", course.getName());
	}

	@Test
	@DirtiesContext
	public void delete_by_id() {
		courseRepository.deleteById(100001);
		Course course = courseRepository.findById(100001);
		assertNull(course);
	}

	@Test
	@DirtiesContext
	public void save() {
		Course course = courseRepository.findById(100001);
		course.setName("Node");
		courseRepository.save(course);
		course = courseRepository.findById(100001);
		assertEquals("Node", course.getName());
	}

}
