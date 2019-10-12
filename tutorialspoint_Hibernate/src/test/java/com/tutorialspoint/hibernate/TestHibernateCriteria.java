package com.tutorialspoint.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestHibernateCriteria {

	@Test
	public void testListEmployeesGt() {
		HibernateCriteria HC = new HibernateCriteria();
		List<?> l = HC.listEmployeesGt(3600);
		assertNotEquals("This list is empty", 0, l.size());
	}

}
