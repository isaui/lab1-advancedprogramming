package id.ac.ui.cs.advprog.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order updateStatus(String orderId, String status) {
        return null;
    }

    @Override
    public Order findById(String orderId) {
        return null;
    }

    @Override
    public List<Order> findAllByAuthor(String author) {
        return null;
    }
    
}
