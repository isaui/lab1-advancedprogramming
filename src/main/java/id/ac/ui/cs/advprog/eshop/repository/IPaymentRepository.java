package id.ac.ui.cs.advprog.eshop.repository;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Payment;

public interface IPaymentRepository {
    Payment save(Payment payment);
    Payment findById(String id);
    List<Payment> findAll();
}
