package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;

public class PaymentTest {
    @Test
    public void testGetPayment() {
        Map<String, String> paymentData = new HashMap<>();
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Cash on Delivery", "SUCCESS", new HashMap<>());
        assertEquals("13652556-012a-4c07-b546-54eb1396d79b", payment.getId());
        assertEquals("Cash on Delivery", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(paymentData, payment.getPaymentData());
    }
    @Test
    void testSetPaymentStatusToInvalidStatus (){
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Cash on Delivery", "SUCCESS", new HashMap<>());
        assertThrows(IllegalArgumentException.class, ()-> payment.setStatus("MEOW"));
    }

    @Test
    void testCreatePaymentInvalidStatus(){
        assertThrows(IllegalArgumentException.class, ()-> {
        new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Cash on Delivery", "MEOW", new HashMap<>());
        });
    }
 
}
