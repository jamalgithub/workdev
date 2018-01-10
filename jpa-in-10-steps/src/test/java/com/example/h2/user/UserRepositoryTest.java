package com.example.h2.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.database.databasedemo.springdata.UserSpringDataRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

	@Autowired
	UserSpringDataRepository userRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void check_todo_count() {
		assertEquals(3, userRepository.count());
	}
}