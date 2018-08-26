package com.jamal.jmock.bo;

import com.jamal.jmock.bo.exception.BOException;
import com.jamal.jmock.model.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;
}
