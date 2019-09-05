package com.github.sarojmandal.jpahibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.sarojmandal.jpahibernate.entity.Course;
import com.github.sarojmandal.jpahibernate.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(int id) {
		return em.find(Course.class, id);
	}

	public void deleteById(int id) {
		Course course = em.find(Course.class, id);
		em.remove(course);

	}

	public Course save(Course course) {
		if (course.getId() == 0) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	public void saveReviews() {
		Review review = new Review(5, "lol");
		Review review1 = new Review(3, "not lol");

		Course course = findById(100001);
		/*
		 * course.addReview(review); course.addReview(review1);
		 */

		review.setCourse(course);
		review1.setCourse(course);
		em.persist(review);
		em.persist(review1);

	}

	public void playWithEntityManager() {
		Course course = new Course("Spring");
		em.persist(course);
		course.setName("lol1");

		em.flush();

		Course course2 = new Course("SpringBoot");
		em.persist(course2);
		em.flush();
		em.clear();

		course2.setName("lol2");
	}

}