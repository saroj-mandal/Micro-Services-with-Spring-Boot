package com.github.sarojmandal.restfulwebservices.user.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@ApiModel(description = "This is a user model")
@JsonFilter(value = "userFilter")
public class JSONFilterUser {
	@JsonIgnore
	private Integer id;

	@Size(min = 2, message = "Name should have ata least 2 character long")
	@ApiModelProperty(notes = "Name should have ata least 2 character long")
	private String name;

	@Past(message = "Birth date should be past date")
	@ApiModelProperty(notes = "Birth date should be past date")
	private Date birthDate;

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public JSONFilterUser(int id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

}
