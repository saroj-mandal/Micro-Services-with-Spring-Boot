package com.github.sarojmandal.jpain10steps;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.sarojmandal.jpain10steps.bean.User;
import com.github.sarojmandal.jpain10steps.service.UserRespository;

@Component
public class UserRepositoryCommandlineRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	UserRespository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Saroj", new Date());
		userRepository.save(user);

		logger.info("User created " + user.getId());
	}

}
