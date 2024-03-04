package id.ac.ui.cs.advprog.eshop.model;
import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {
    private String id;
    private List<Product> products;
    private long orderTime;
    private String author;
    private String status;

    public Order(String id, List<Product> products, long orderTime, String author) {
        this.id = id;
        this.orderTime = orderTime;
        this.author = author;
        this.status = "WAITING_PAYMENT";
        if(products.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            this.products = products;
        }
    }

    public Order(String id, List<Product> products, long orderTime, String author, String status) {
        this(id, products, orderTime, author);
        String[] statusList = {"WAITING_PAYMENT","FAILED","SUCCESS","CANCELLED"};
        if(Arrays.stream(statusList).noneMatch(item -> item.equals(status))){
            throw new IllegalArgumentException();
        }
        else{
            this.status = status;
        }
    }
    public void setStatus(String status) {
        String[] statusList = {"WAITING_PAYMENT","FAILED","SUCCESS","CANCELLED"};
        if(Arrays.stream(statusList).noneMatch(item -> item.equals(status))){
            throw new IllegalArgumentException();
        }
        else{
            this.status = status;
        }
    }

    
}
