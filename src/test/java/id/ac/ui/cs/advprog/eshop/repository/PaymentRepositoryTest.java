package id.ac.ui.cs.advprog.eshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;
    @BeforeEach
    void setUp(){
        paymentRepository = new PaymentRepository();
        payments = new ArrayList<>();
        Payment payment1 = new Payment("ABCDE", "Cash On Delivery", "SUCCESS", new HashMap<>());
        Payment payment2 = new Payment("23456", "Cash On Delivery", "SUCCESS", new HashMap<>());
        Payment payment3 = new Payment("901234", "Cash On Delivery", "SUCCESS", new HashMap<>());
        Payment payment4 = new Payment("xyzabc", "Cash On Delivery", "SUCCESS", new HashMap<>());
        Payment payment5 = new Payment("defghij", "Cash On Delivery", "SUCCESS", new HashMap<>());
        payments.add(payment1);
        payments.add(payment2);
        payments.add(payment3);
        payments.add(payment4);
        payments.add(payment5);
    }

    @Test
    void testSaveNewPayment(){
        Payment payment = payments.get(0);
        Payment result = paymentRepository.save(payment);
        Payment findResult = paymentRepository.findById(payments.get(0).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
    }
    @Test
    void testUpdatePayment(){
        Payment payment = payments.get(0);
        paymentRepository.save(payment);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), PaymentStatus.REJECTED.getValue(), payment.getPaymentData());
        Payment result = paymentRepository.save(newPayment);
        Payment findResult = paymentRepository.findById(payment.getId());
        assertEquals(newPayment.getId(), result.getId());
        assertEquals(newPayment.getId(), findResult.getId());
        assertEquals(PaymentStatus.REJECTED.getValue(), findResult.getStatus());
        assertEquals(newPayment.getPaymentData(), findResult.getPaymentData());
    }
    @Test
    void testFindByIdIfIdFound(){
        for(Payment payment: payments){
            paymentRepository.save(payment);
        }
        Payment expectedPayment = payments.get(0);
        Payment findResult = paymentRepository.findById(expectedPayment.getId());
        assertEquals(expectedPayment.getId(), findResult.getId());
        assertEquals(expectedPayment.getMethod(), findResult.getMethod());
        assertEquals(expectedPayment.getStatus(), findResult.getStatus());
        assertEquals(expectedPayment.getPaymentData(), findResult.getPaymentData());
    }
    @Test
    void testFindByIdIfIdNotFound(){
        for(Payment payment: payments){
            paymentRepository.save(payment);
        }
        Payment findResult = paymentRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test
    void testFindAll(){     
        for(Payment payment: payments){
            paymentRepository.save(payment);
        }
        List<Payment> currentPayments = paymentRepository.findAll();
        assertEquals(5, currentPayments.size());
    }

}
