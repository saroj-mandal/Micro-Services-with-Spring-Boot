package com.github.sarojmandal.jpahibernate;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.sarojmandal.jpahibernate.entity.Employee;
import com.github.sarojmandal.jpahibernate.entity.PartTimeEmployee;
import com.github.sarojmandal.jpahibernate.entity.PermanentEmployee;
import com.github.sarojmandal.jpahibernate.repository.CourseRepository;
import com.github.sarojmandal.jpahibernate.repository.EmployeeRepository;
import com.github.sarojmandal.jpahibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*
		 * logger.info("Course : {}", courseRepository.findById(100001)); //
		 * courseRepository.deleteById(100001); courseRepository.save(new
		 * Course("React"));
		 */
		// courseRepository.playWithEntityManager();
		// studentRepository.saveStudentWithPassport();
		// courseRepository.saveReviews();
		/*
		 * Course course = courseRepository.findById(100001);
		 * System.out.println(course); System.out.println(course.getStudents());
		 */

		/*
		 * Student student = studentRepository.findById(300001);
		 * System.out.println(student); System.out.println(student.getCourses());
		 * 
		 * student = new Student("Hemu"); Course course = new Course("ATG");
		 * student.addCourse(course); courseRepository.save(course);
		 * studentRepository.save(student); System.out.println(student);
		 */
		Employee pe = new PermanentEmployee("Saroj", 10);
		Employee pte = new PartTimeEmployee("Vini", 1000);
		employeeRepository.save(pe);
		employeeRepository.save(pte);
		System.out.println(employeeRepository.findAllPartTimeEmployee());
		System.out.println(employeeRepository.findAllPermanentEmployee());
		String s = new String();
	}

}
