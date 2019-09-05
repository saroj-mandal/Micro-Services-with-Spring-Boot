package com.github.sarojmandal.jpahibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PermanentEmployee extends Employee {

	private double salary;

	protected PermanentEmployee() {
	}

	/**
	 * @param name
	 */
	public PermanentEmployee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PermanentEmployee [salary=" + salary + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}

}
