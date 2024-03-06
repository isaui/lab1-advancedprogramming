package id.ac.ui.cs.advprog.eshop.service.impl;

import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.IPaymentRepository;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired IPaymentRepository paymentRepository;
    @Autowired OrderRepository orderRepository;
    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        validateOrder(order);
        return paymentRepository.save(new Payment(order.getId(), method, "SUCCESS", paymentData));
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        if(!PaymentStatus.contains(status)){
            throw new IllegalArgumentException();
        }
        Payment selectedPayment = paymentRepository.findById(payment.getId());
        validatePayment(selectedPayment);
        Order order = orderRepository.findById(payment.getId());
        validateOrder(order);
        Order newOrder = new Order(order.getId(),order.getProducts() , order.getOrderTime(), order.getAuthor(), PaymentStatus.REJECTED.getValue().equals(status)? OrderStatus.FAILED.getValue(): OrderStatus.SUCCESS.getValue());
        orderRepository.save(newOrder);
        return paymentRepository.save(new Payment(payment.getId(), payment.getMethod(), status, payment.getPaymentData()));
    }

    private void validatePayment(Payment payment){
        if(payment == null){
            throw new NoSuchElementException();
        }
    }

    private void validateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
}
