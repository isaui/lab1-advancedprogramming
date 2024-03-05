package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import id.ac.ui.cs.advprog.eshop.model.Payment;

@Component
public class PaymentRepository implements IPaymentRepository {
    Map<String, Payment> payments = new HashMap<>();
    @Override
    public Payment save(Payment payment){
        payments.put(payment.getId(), payment);
        return payment;
    }
    @Override
    public Payment findById(String id){
        return payments.get(id);
    }
    @Override
    public List<Payment> findAll(){
        return new ArrayList<>(payments.values());
    }
}
