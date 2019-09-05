package com.github.sarojmandal.jpahibernate.entity;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private double dailyWage;

	protected PartTimeEmployee() {
	}

	/**
	 * @param name
	 */
	public PartTimeEmployee(String name, double dailyWage) {
		super(name);
		this.dailyWage = dailyWage;
	}

	/**
	 * @return the salary
	 */
	public double getDailyWage() {
		return dailyWage;
	}

	/**
	 * @param dailyWage the salary to set
	 */
	public void setDailyWage(double dailyWage) {
		this.dailyWage = dailyWage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PartTimeEmployee [dailyWage=" + dailyWage + ", getName()=" + getName() + ", getId()=" + getId() + "]";
	}

}
