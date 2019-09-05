package com.github.sarojmandal.restfulwebservices.user;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sarojmandal.restfulwebservices.user.bean.User;

@RestController
public class VersionUserResourceController {
	@GetMapping("/v1/users/")
	public User getUsersV1() {
		return new User(1, "Saroj", new Date());
	}

	@GetMapping("/v2/users/")
	public User getUsersV2() {
		return new User(1, "Manoj", new Date());
	}

	@GetMapping(value = "/users/param", params = "version=1")
	public User getUsersParamV1() {
		return new User(1, "Saroj", new Date());
	}

	@GetMapping(value = "/users/param", params = "version=2")
	public User getUsersParamV2() {
		return new User(1, "Manoj", new Date());
	}

	@GetMapping(value = "/users/header", headers = "api-version=1")
	public User getUsersHeaderV1() {
		return new User(1, "Saroj", new Date());
	}

	@GetMapping(value = "/users/header", headers = "api-version=2")
	public User getUsersHeaderV2() {
		return new User(1, "Manoj", new Date());
	}

	@GetMapping(value = "/users/produces", produces = "application/saroj.com-v1+json")
	public User getUsersProducesV1() {
		return new User(1, "Saroj", new Date());
	}

	@GetMapping(value = "/users/produces", produces = "application/saroj.com-v2+json")
	public User getUsersProducesV2() {
		return new User(1, "Manoj", new Date());
	}
}
