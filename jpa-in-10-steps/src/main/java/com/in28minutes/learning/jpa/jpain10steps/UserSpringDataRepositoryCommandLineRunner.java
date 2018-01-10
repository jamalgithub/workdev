package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.database.databasedemo.entity.User;
import com.in28minutes.database.databasedemo.springdata.UserSpringDataRepository;

//@Component
public class UserSpringDataRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserSpringDataRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserSpringDataRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne.get());

		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);			
	}
	
}