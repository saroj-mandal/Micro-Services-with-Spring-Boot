package com.github.sarojmandal.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.github.sarojmandal.restfulwebservices.user.bean.JSONFilterUser;
import com.github.sarojmandal.restfulwebservices.user.exception.UserNotFoundException;
import com.github.sarojmandal.restfulwebservices.user.service.UserDaoService;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userDaoService;

	// retrieve all user
	@GetMapping("/users")
	public MappingJacksonValue retrieveAllUsers() {
		List<JSONFilterUser> users = userDaoService.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("birthDate");
		FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

	// retrieve user
	@GetMapping("/users/{id}")
	public MappingJacksonValue retrieveUser(@PathVariable int id) {
		JSONFilterUser user = userDaoService.findOne(id);
		if (null == user) {
			throw new UserNotFoundException("id = " + id);
		}
		Resource<JSONFilterUser> resource = new Resource<JSONFilterUser>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(resource);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	@PostMapping("/users")
	public ResponseEntity<JSONFilterUser> creatUser(@Valid @RequestBody JSONFilterUser user) {
		JSONFilterUser createdUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();
		ResponseEntity<JSONFilterUser> userEntity = ResponseEntity.created(location).build();
		return userEntity;
	}

	// retrieve user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		JSONFilterUser user = userDaoService.deleteById(id);
		if (null == user) {
			throw new UserNotFoundException("id = " + id);
		}
	}
}
