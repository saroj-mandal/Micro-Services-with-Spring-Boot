package com.github.sarojmandal.databasedemo;

import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int id = 100001;
		logger.info("Users  with id {} is : {}", id, personJpaRepository.findPersonById(id));
		Person person = new Person("Hemu", "VijayWara", new Date());

		logger.info("Creating user: {} and success: {}", person, personJpaRepository.createPerson(person));

		person = new Person(1, "Hemanth N", "Vijaywada", new Date().from(Instant.EPOCH));
		logger.info("Updating user: {} and success: {}", person, personJpaRepository.updatePerson(person));

		logger.info("All Users : {}", personJpaRepository.findAllPerson().size());
		personJpaRepository.deletePersonById(id);

		logger.info("All Users : {}", personJpaRepository.findAllPerson().size());

	}

}
