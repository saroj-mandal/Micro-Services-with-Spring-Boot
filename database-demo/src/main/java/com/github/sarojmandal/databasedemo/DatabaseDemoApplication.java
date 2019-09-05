package com.github.sarojmandal.databasedemo;

import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users : {}", personJdbcDao.findAllPerson());
		int id = 100001;
		logger.info("Users  with id {} is : {}", id, personJdbcDao.findPersonById(id));
		id = 100002;
		logger.info("Users  with id {} is deleted: {}", id, personJdbcDao.deletePersonById(id));

		Person person = new Person(100004, "Hemu", "VijayWara", new Date());
		logger.info("Creating user: {} and success: {}", person, personJdbcDao.createPerson(person));

		person = new Person(100004, "Hemanth N", "Vijaywada", new Date().from(Instant.EPOCH));
		logger.info("Updating user: {} and success: {}", person, personJdbcDao.updatePerson(person));

	}

}
