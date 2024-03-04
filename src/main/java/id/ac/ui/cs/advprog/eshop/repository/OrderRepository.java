package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.model.Order;

@Repository
public class OrderRepository {
    private List<Order> orderData = new ArrayList<>();

    public Order save(Order order){
        boolean isUpdate = false;
        for(int i = 0; i< orderData.size(); i++){
            Order currentOrder = orderData.get(i);
            if(currentOrder.getId().equals(order.getId())){
                orderData.add(i, order);
                isUpdate = true;
            }
        }
        if(!isUpdate){
            orderData.add(order);
        }
        return order;
    }

    public Order findById(String id){
        for (Order order : orderData) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    public List<Order> findAllByAuthor(String author){
        return orderData.stream().filter(order -> order.getAuthor().equals(author)).collect(Collectors.toList());
    }
    
}
