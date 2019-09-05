package com.github.sarojmandal.jpahibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.sarojmandal.jpahibernate.entity.Course;
import com.github.sarojmandal.jpahibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class StudentRepositoryTest {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;

	@Test
	@Transactional
	public void find_by_id() {
		Student student = studentRepository.findById(300001);
		logger.info("Student = {} ", student);
		logger.info("Passport = {} ", student.getPassport());
		assertEquals("Saroj", student.getName());
	}

	@Test
	@DirtiesContext
	public void delete_by_id() {
		studentRepository.deleteById(100001);
		Student student = studentRepository.findById(100001);
		assertNull(student);
	}

	@Test
	@DirtiesContext
	public void save() {
		Student student = studentRepository.findById(100001);
		student.setName("Node");
		studentRepository.save(student);
		student = studentRepository.findById(100001);
		assertEquals("Node", student.getName());
	}

	@Test
	public void testBidirectional() {
		studentRepository.testBidirectional();
	}
	
	@Test
	public void saveStudentWithCourse() {
		Student student = new Student("Hemu");
		Course course = new Course("ATG");
		student.addCourse(course);
		courseRepository.save(course);
		studentRepository.save(student);
		System.out.println(student);
	}
}
