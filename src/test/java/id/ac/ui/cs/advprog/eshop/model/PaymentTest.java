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

    @Test
    void testVoucherFieldIsNull(){
        // Voucher code is null
        Payment paymentWithNullVoucherCode = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Payment by Voucher Code", new HashMap<>());
        assertEquals(PaymentStatus.REJECTED.getValue(), paymentWithNullVoucherCode.getStatus());
    }
    @Test
    void testVoucherCodeIsNotValid(){
       String[] voucherCodeList= {"","A", "ESHOPEFGHIJKLMN541", "EFGHIJKLMN54123A", "ESHOP1234ABC567A"}; 
       // Empty, <16, M>16, No 8 Numericals character
       for(String code: voucherCodeList){
            Map<String,String> paymentData = new HashMap<>();
            paymentData.put("voucherCode", code);
            Payment payment= new Payment("13652556-012a-4c07-b546-54eb1396d79d", "Payment by Voucher Code", paymentData);
            assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
       }
    }

    @Test
    void testVoucherCodeIsValid(){
        Map<String,String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b", "Payment by Voucher Code",paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }
 
}
