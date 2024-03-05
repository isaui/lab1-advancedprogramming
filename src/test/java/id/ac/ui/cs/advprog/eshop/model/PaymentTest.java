package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import java.util.Map;

import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;


public class PaymentTest {
    @Test
    public void testGetPayment() {
        Map<String, String> paymentData = new HashMap<>();
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Cash on Delivery", PaymentStatus.SUCCESS.getValue(), new HashMap<>());
        assertEquals("13652556-012a-4c07-b546-54eb1396d79b", payment.getId());
        assertEquals("Cash on Delivery", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }
    @Test
    void testSetPaymentStatusToInvalidStatus (){
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Cash on Delivery", PaymentStatus.SUCCESS.getValue(), new HashMap<>());
        assertThrows(IllegalArgumentException.class, ()-> payment.setStatus("MEOW"));
    }

    @Test
    void testCreatePaymentInvalidStatus(){
        assertThrows(IllegalArgumentException.class, ()-> {
        new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Cash on Delivery", "MEOW", new HashMap<>());
        });
    }
 
}
