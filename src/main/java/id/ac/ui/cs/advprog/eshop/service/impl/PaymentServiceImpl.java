package id.ac.ui.cs.advprog.eshop.service.impl;

import java.util.Map;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        throw new UnsupportedOperationException("Unimplemented method 'addPayment'");
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }

    @Override
    public Payment getPayment(String paymentId) {
        throw new UnsupportedOperationException("Unimplemented method 'getPayment'");
    }

    @Override
    public List<Payment> getAllPayments() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllPayments'");
    }
    
}
