package id.ac.ui.cs.advprog.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.repository.IProductRepository;

@Service
public class ProductDeletionServiceImpl implements ProductDeletionService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public void deleteProductById(String productId) {
        productRepository.delete(productId);
    }
}