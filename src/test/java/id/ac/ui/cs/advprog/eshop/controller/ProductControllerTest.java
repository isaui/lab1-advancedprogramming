package id.ac.ui.cs.advprog.eshop.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductCreationService;
import id.ac.ui.cs.advprog.eshop.service.ProductDeletionService;
import id.ac.ui.cs.advprog.eshop.service.ProductModificationService;
import id.ac.ui.cs.advprog.eshop.service.ProductRetrievalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductControllerTest {

    @Mock
    private ProductCreationService productCreationService;
    @Mock
    private ProductDeletionService productDeletionService;
    @Mock
    private ProductModificationService productModificationService;
    @Mock
    private ProductRetrievalService productRetrievalService;
    @InjectMocks
    private ProductController productController;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("CreateProduct", viewName);
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        String viewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productCreationService, times(1)).create(product);
    }

    @Test
    void testProductListPage() {
        List<Product> productList = new ArrayList<>();
        when(productRetrievalService.findAll()).thenReturn(productList);

        String viewName = productController.productListPage(model);

        assertEquals("ProductList", viewName);
        verify(model, times(1)).addAttribute("products", productList);
    }

    @Test
    void testEditProductPage() {
        String productId = "123";
        Product product = new Product();
        when(productRetrievalService.findById(productId)).thenReturn(product);

        String viewName = productController.editProductPage(productId, model);

        assertEquals("EditProduct", viewName);
        verify(model, times(1)).addAttribute("product", product);
    }

    @Test
    void testEditProductPost() {
        Product product = new Product();
        String viewName = productController.editProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productModificationService, times(1)).update(product.getProductId(), product);
    }

    @Test
    void testDeleteProduct() {
        String productId = "123";
        String viewName = productController.deleteProduct(productId);
        assertEquals("redirect:list", viewName);
        verify(productDeletionService, times(1)).deleteProductById(productId);
    }
}
