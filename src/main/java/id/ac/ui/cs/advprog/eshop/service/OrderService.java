package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order updateStatus(String orderId, String status);
    Order findById(String orderId);
    List<Order> findAllByAuthor(String author);
}
