package com.github.sarojmandal.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.sarojmandal.jpahibernate.entity.Employee;
import com.github.sarojmandal.jpahibernate.entity.PartTimeEmployee;
import com.github.sarojmandal.jpahibernate.entity.PermanentEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	public Employee findById(int id) {
		return em.find(Employee.class, id);
	}

	public void deleteById(int id) {
		Employee employee = em.find(Employee.class, id);
		em.remove(employee);

	}

	public Employee save(Employee employee) {
		if (employee.getId() == 0) {
			em.persist(employee);
		} else {
			em.merge(employee);
		}
		return employee;
	}

	public List<Employee> findAll() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	public List<? extends Employee> findAllPermanentEmployee() {
		return em.createQuery("select e from PermanentEmployee e", PermanentEmployee.class).getResultList();
	}

	public List<? extends Employee> findAllPartTimeEmployee() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

}