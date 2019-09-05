package com.github.sarojmandal.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.github.sarojmandal.jpain10steps.bean.User;

@Repository
@Transactional
public class UserDaoService {

	@PersistenceContext
	private EntityManager entityManager;

	public long inserUser(User user) {
		entityManager.persist(user);
		return user.getId();
	}

}
