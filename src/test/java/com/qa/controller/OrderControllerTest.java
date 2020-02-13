//package com.qa.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.databaseobjects.Customer;
//import com.qa.databaseobjects.ItemOrders;
//import com.qa.databaseobjects.Order;
//import com.qa.services.CustomerService;
//import com.qa.services.ItemOrdersService;
//import com.qa.services.OrderService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrderControllerTest {
//	
//	/**
//	 *  The thing I want to fake functionality for
//	 */
//	@Mock
//	private OrderService orderService;
//	@Mock
//	private ItemOrdersService itemOrderService;
//	@Mock
//	private CustomerService customerService;
//	
//	/**
//	 * Spy is used because i want to mock some methods inside the item I'm testing
//	 * InjectMocks uses dependency injection to insert the mock into the customer controller
//	 */
//	@Spy
//	@InjectMocks
//	private OrderController orderController;
//
//	@Test
//	public void readAllTest() {		
////		List<Order> orders = new ArrayList<>();
////		Customer customer = new Customer(1, "Sam White");
////		orders.add(new Order(1, customer));
////		
////		List<ItemOrders> itemOrders = new ArrayList<>();
////		itemOrders.add(new ItemOrders(1, 1, 1, 10, 1000));
////		itemOrders.add(new ItemOrders(2, 1, 1, 10, 1000));
////		itemOrders.add(new ItemOrders(3, 1, 1, 10, 1000));
////		itemOrders.add(new ItemOrders(4, 1, 1, 10, 1000));
////		itemOrders.add(new ItemOrders(5, 1, 1, 10, 1000));
////		
////		Mockito.when(orderService.readAll()).thenReturn(orders);
////		Mockito.when(itemOrderService.readAll()).thenReturn(itemOrders);
////		
//		orderController.readAll();
//		Mockito.verify(orderService, Mockito.times(1)).readAll();
//
////		Mockito.verify(itemOrderService, Mockito.times(1)).readAll();
//	}
//
////	@Test
////	public void createTest() {
////		String name = "Sam White";
////		Mockito.doReturn(name).when(orderController).getStringInput();
////		Customer customer = new Customer(name);
////		orderController.create();
////		Mockito.verify(orderService, Mockito.times(1)).create(customer);
////	}
////
////	@Test
////	public void updateTest() {
////		int id = 1;
////		String name = "Sam White";
////		
////		Mockito.doReturn(id).when(orderController).getIntInput();
////		Mockito.doReturn(name).when(orderController).getStringInput();
////
////		Customer customer = new Customer(id, name);
////		orderController.update();
////		Mockito.verify(orderService, Mockito.times(1)).update(customer);
////	}
////	
////	@Test
////	public void deleteTest() {
////		int id = 1;
////		Mockito.doReturn(id).when(orderController).getIntInput();
////		orderController.delete();
////		Mockito.verify(orderService, Mockito.times(1)).delete(1);
////	}
//	
//}