package id.ac.ui.cs.advprog.eshop.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.IPaymentRepository;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;
import id.ac.ui.cs.advprog.eshop.service.impl.OrderServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.impl.PaymentServiceImpl;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentService paymentService = new PaymentServiceImpl();
    @InjectMocks
    OrderService orderService = new OrderServiceImpl();
    @Mock
    IPaymentRepository paymentRepository;
    @Mock
    OrderRepository orderRepository;
    List<Order> orders;
    List<Payment> payments;
    
    @BeforeEach
    void setUp(){
        payments = new ArrayList<>();
        orders = new ArrayList<>();
        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b", PaymentMethod.COD.getValue(), PaymentStatus.SUCCESS.getValue(), new HashMap<>());
        Payment payment2 = new Payment("7f9e15bb-4b15-42f4-aebc-c3af385fb078", PaymentMethod.PAYMENT_BY_VOUCHER.getValue(), PaymentStatus.SUCCESS.getValue(), new HashMap<>());
        payments.add(payment1);
        payments.add(payment2);
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);       
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078", products, 1708570000L, "Safira Sudrajat");
        orders.add(order2);
    }
    @Test
    void testAddPaymentWhenOrderIsValidOrder(){
        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).save(any(Payment.class));
        Payment result = paymentService.addPayment(orders.get(0), payment.getMethod(), payment.getPaymentData());
        verify(paymentRepository, times(1)).save(any(Payment.class));
        assertEquals(payment.getId(), result.getId());
    }
    @Test
    void testAddPaymentWhenOrderIsInvalidOrder(){
        Payment payment = payments.get(1);
        assertThrows(IllegalArgumentException.class, ()-> paymentService.addPayment(null, payment.getMethod(), payment.getPaymentData()));
    }
    @Test
    void testSetStatusPaymentToValidStatus(){
        Payment payment = payments.get(1);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), PaymentStatus.REJECTED.getValue(), payment.getPaymentData());

        Order order = orders.get(1);
        Order newOrder = new Order(order.getId(),order.getProducts() , order.getOrderTime(), order.getAuthor(), OrderStatus.FAILED.getValue());

        doReturn(payment).when(paymentRepository).findById(payment.getId());
        doReturn(newPayment).when(paymentRepository).save(any(Payment.class));

        doReturn(order).when(orderRepository).findById(order.getId());
        doReturn(newOrder).when(orderRepository).save(any(Order.class));

        Payment result = paymentService.setStatus(payment, PaymentStatus.REJECTED.getValue());
        verify(paymentRepository, times(1)).save(any(Payment.class));
        assertEquals(PaymentStatus.REJECTED.getValue(), result.getStatus());

        Order orderResult = orderService.updateStatus(order.getId(), OrderStatus.FAILED.getValue());
        assertEquals(OrderStatus.FAILED.getValue(), orderResult.getStatus());
        verify(orderRepository, times(2)).save(any(Order.class));
    }
    @Test
    void testSetStatusPaymentToInvalidStatus(){
        Payment payment = payments.get(1);
        assertThrows(java.lang.IllegalArgumentException.class, ()-> paymentService.setStatus(payment, "MEOW"));
    }
    @Test
    void testGetPaymentNotFound(){
        doReturn(null).when(paymentRepository).findById("zczc");
        assertNull(paymentService.getPayment("zczc"));
    }
    @Test
    void testGetPaymentFound(){
        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).findById(payment.getId());
        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }
    @Test
    void testGetAllPaymentsIsEmpty(){
        doReturn(new ArrayList<Payment>()).when(paymentRepository).findAll();
        List<Payment> result = paymentService.getAllPayments();
        assertTrue(result.isEmpty());
    }
    @Test
    void testGetAllPaymentsIsNotEmpty(){
        doReturn(payments).when(paymentRepository).findAll();
        List<Payment> result = paymentService.getAllPayments();
        for(int i = 0; i < result.size();i++){
            Payment paymentResult = result.get(i);
            assertEquals(payments.get(i).getId(), paymentResult.getId());
        }
        assertEquals(2, result.size());
    }
    
}