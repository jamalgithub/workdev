package com.jamal.jmock.dao;

import java.sql.SQLException;

import com.jamal.jmock.model.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int create(Order order) throws SQLException {
		return 0;
	}

	@Override
	public Order read(int id) throws SQLException {
		return null;
	}

	@Override
	public int update(Order order) throws SQLException {
		return 0;
	}

	@Override
	public int delete(int id) throws SQLException {
		return 0;
	}

}
