package id.ac.ui.cs.advprog.eshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public Order createOrder(Order order) {
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public Order updateStatus(String orderId, String status) {
        throw new UnsupportedOperationException("Unimplemented method 'updateStatus'");
    }

    @Override
    public Order findById(String orderId) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Order> findAllByAuthor(String author) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllByAuthor'");
    }
    
}
