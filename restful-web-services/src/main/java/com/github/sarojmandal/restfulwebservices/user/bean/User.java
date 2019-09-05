package com.github.sarojmandal.restfulwebservices.user.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@ApiModel(description = "This is a user model")
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should have ata least 2 character long")
	@ApiModelProperty(notes = "Name should have ata least 2 character long")
	private String name;

	@Past(message = "Birth date should be past date")
	@ApiModelProperty(notes = "Birth date should be past date")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public User(int id, String name, Date birthDate) {
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

	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
