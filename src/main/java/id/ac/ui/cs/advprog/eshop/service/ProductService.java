package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    Product findById(String productId);
    public void update(String productId, Product product);
    public void deleteProductById(String productId);
}