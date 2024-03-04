package id.ac.ui.cs.advprog.eshop.model;
import java.util.List;

public class Order {
    private String id;
    private List<Product> products;
    private long orderTime;
    private String author;
    private String status;

    public Order(String id, List<Product> products, long orderTime, String author) {
        
        this.id = id;
        this.products = products;
        this.orderTime = orderTime;
        this.author = author;
        this.status = "WAITING_PAYMENT";
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Products list cannot be empty");
        }
    }

    public Order(String id, List<Product> products, long orderTime, String author, String status) {
        
        this.id = id;
        this.products = products;
        this.orderTime = orderTime;
        this.author = author;
        setStatus(status);
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Products list cannot be empty");
        }
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        if(isValidStatus(status)){
            this.status = status;
        }
        else{
            throw new IllegalArgumentException("Invalid status: " + status);
        }
        
    }
    private boolean isValidStatus(String status) {
        return status.equals("WAITING_PAYMENT") || status.equals("FAILED") || status.equals("CANCELLED") || status.equals("SUCCESS");
    }
    
}
