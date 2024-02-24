package id.ac.ui.cs.advprog.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.IProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductCreationService;

@Service
public class ProductCreationServiceImpl implements ProductCreationService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }
}
