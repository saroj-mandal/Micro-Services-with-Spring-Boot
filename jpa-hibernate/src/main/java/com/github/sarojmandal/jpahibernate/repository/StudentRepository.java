package com.github.sarojmandal.jpahibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.sarojmandal.jpahibernate.entity.Passport;
import com.github.sarojmandal.jpahibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;

	public Student findById(int id) {
		return em.find(Student.class, id);
	}

	public void deleteById(int id) {
		Student student = em.find(Student.class, id);
		em.remove(student);

	}

	public Student save(Student student) {
		if (student.getId() == 0) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("AJD84343");
		em.persist(passport);
		Student student = new Student("Hemu");
		student.setPassport(passport);
		em.persist(student);
	}

	public void testBidirectional() {
		Passport passport = em.find(Passport.class, 400001);
		System.out.println(passport.getStudent());
	}
	
}