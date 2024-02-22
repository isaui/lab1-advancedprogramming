package id.ac.ui.cs.advprog.eshop.repository;

import java.util.Iterator;

import id.ac.ui.cs.advprog.eshop.model.Product;

public interface IProductRepository {
    public Product create(Product product);
    public Iterator<Product> findAll();
    public Product findById(String id);
    public Product update(String id, Product updatedProduct);
    public void delete(String id);
}
