package com.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.in28minutes.database.databasedemo.entity.User;
import com.in28minutes.database.databasedemo.jpa.UserJpaRepository;

//@Component
public class UserJpaRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserJpaRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserJpaRepository userDaoService;
	
	@Override
	public void run(String... arg0) throws Exception {		
		
		log.info("-------------------------------");
		log.info("Adding Tom as Admin");
		log.info("-------------------------------");
		User tom = new User("Tom", "Admin");
		userDaoService.insert(tom);
		log.info("Inserted Tom" + tom);

		log.info("-------------------------------");
		log.info("Finding user with id 1");
		log.info("-------------------------------");
		User user = userDaoService.find(1L);
		log.info(user.toString());

		log.info("-------------------------------");
		log.info("Finding all users");
		log.info("-------------------------------");
		log.info(userDaoService.findAll().toString());
	}
}