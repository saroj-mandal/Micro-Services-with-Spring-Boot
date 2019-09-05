package com.github.sarojmandal.databasedemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findPersonById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person updatePerson(Person person) {
		return entityManager.merge(person);
	}

	public Person createPerson(Person person) {
		return entityManager.merge(person);
	}

	public void deletePersonById(int id) {
		Person person = findPersonById(id);
		entityManager.remove(person);
	}

	public List<Person> findAllPerson() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}

}
