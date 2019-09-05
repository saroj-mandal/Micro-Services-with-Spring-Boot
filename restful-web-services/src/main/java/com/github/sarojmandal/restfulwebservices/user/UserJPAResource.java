package com.github.sarojmandal.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.sarojmandal.restfulwebservices.user.bean.Post;
import com.github.sarojmandal.restfulwebservices.user.bean.User;
import com.github.sarojmandal.restfulwebservices.user.exception.UserNotFoundException;
import com.github.sarojmandal.restfulwebservices.user.repository.PostRepository;
import com.github.sarojmandal.restfulwebservices.user.repository.UserRepository;

@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	// retrieve all user
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	// retrieve user
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id = " + id);
		}
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> creatUser(@Valid @RequestBody User user) {
		User createdUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();
		ResponseEntity<User> userEntity = ResponseEntity.created(location).build();
		return userEntity;
	}

	// retrieve user
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	// retrieve all user
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id = " + id);
		}
		return user.get().getPosts();
	}

	@GetMapping("/jpa/users/{id}/posts/{postId}")
	public Resource<Post> retrieveUserPost(@PathVariable int id, @PathVariable int postId) {
		Optional<Post> postOptional = postRepository.findById(postId);
		if (!postOptional.isPresent()) {
			throw new UserNotFoundException("post not found = " + postId);
		}
		if (postOptional.get().getUser().getId() != id) {
			throw new UserNotFoundException("user id = " + id);
		}
		Resource<Post> postResource = new Resource<Post>(postOptional.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(getClass()).retrieveUser(id));
		postResource.add(linkTo.withRel("user"));
		return postResource;
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> creatUserPost(@Valid @RequestBody Post post, @PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id = " + id);
		}
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		ResponseEntity<Post> postEntity = ResponseEntity.created(location).build();
		return postEntity;
	}
}
