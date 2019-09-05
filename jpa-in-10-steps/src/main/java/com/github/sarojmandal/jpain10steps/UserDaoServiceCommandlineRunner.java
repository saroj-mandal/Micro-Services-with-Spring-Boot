package com.github.sarojmandal.jpain10steps;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.sarojmandal.jpain10steps.bean.User;
import com.github.sarojmandal.jpain10steps.service.UserDaoService;

@Component
public class UserDaoServiceCommandlineRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	UserDaoService userDaoService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Saroj", new Date());
		long insert = userDaoService.inserUser(user);

		logger.info("User created " + insert);
	}

}
