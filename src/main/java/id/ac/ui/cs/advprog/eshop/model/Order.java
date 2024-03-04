package id.ac.ui.cs.advprog.eshop.model;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Order {
    private String id;
    private List<Product> products;
    private long orderTime;
    private String author;
    @Setter
    private String status;

    public Order(String id, List<Product> products, long orderTime, String author) {
    }

    public Order(String id, List<Product> products, long orderTime, String author, String status) {
    }

    
}
