package com.github.sarojmandal.currencyexchangeservice.bean;

import org.springframework.stereotype.Component;

@Component
public class Configuration {
	private int minimum;
	private int maximum;
	
	Configuration() {
		
	}

	/**
	 * @param minimum
	 * @param maximum
	 */
	public Configuration(int minimum, int maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}

	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}

	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
