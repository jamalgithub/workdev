package com.jamal.jmock.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jamal.jmock.bo.exception.BOException;
import com.jamal.jmock.dao.OrderDAO;
import com.jamal.jmock.model.Order;

public class OrderBOImplTest {

	private static final int ORDER_ID = 123;

	@Mock
	OrderDAO dao;
	
	@InjectMocks
	private OrderBOImpl bo;
	
	@Before
	public void Setup() {
		MockitoAnnotations.initMocks(this);
		
		//bo = new OrderBOImpl();
		bo.setDao(dao);
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {				
		Order order = new Order();
		
		when(dao.create(order)).thenReturn(new Integer(1));		
		//when(dao.create((Order) any(Order.class))).thenReturn(new Integer(1));		
		boolean result = bo.placeOrder(order);
		
		assertTrue(result);
		//assertThat(result, is(true));
		verify(dao).create(order);
		//verify(dao, times(1)).create(order);		
		//verify(dao, atLeast(1)).create(order);		
		//verify(dao, atMost(1)).create(order);		
	}

	@Test
	public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		
		when(dao.create(order)).thenReturn(new Integer(0));		
		boolean result = bo.placeOrder(order);
		
		assertFalse(result);
		verify(dao).create(order);
	}
	
	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		
		//when(dao.create(order)).thenThrow(SQLException.class);		
		when(dao.create(any(Order.class))).thenThrow(SQLException.class);		
		bo.placeOrder(order);		
	}
	
	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		
		//when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.read(anyInt())).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(ORDER_ID);
		
		assertTrue(result);
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}
	
	@Test
	public void cancelOrder_Should_not_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result = bo.cancelOrder(ORDER_ID);
		
		assertFalse(result);
		verify(dao).read(ORDER_ID);
		verify(dao).update(order);
	}
	
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOExceptionOnRead() throws SQLException, BOException {
		when(dao.read(ORDER_ID)).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);
	}
	
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);		
	}
	
	@Test
	public void deleteOrder_Delete_The_Order() throws SQLException, BOException {
		when(dao.delete(ORDER_ID)).thenReturn(1);
		boolean result = bo.deleteOrder(ORDER_ID);
		
		assertTrue(result);
		verify(dao).delete(ORDER_ID);
	}
	
}
