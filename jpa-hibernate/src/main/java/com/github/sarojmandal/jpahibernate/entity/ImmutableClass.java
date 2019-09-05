package com.github.sarojmandal.jpahibernate.entity;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {
	private final String name;
	private final List<String> list;

	public ImmutableClass(String name, List<String> list) {
		this.name = name;
		this.list = list;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the list
	 */
	public List<String> getList() {
		return new ArrayList<>(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImmutableClass [name=" + name + ", list=" + list + "]";
	}

}
