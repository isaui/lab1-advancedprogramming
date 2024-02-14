package id.ac.ui.cs.advprog.eshop.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
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
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("createProduct", viewName);
    }

    @Test
    public void testCreateProductPost() {
        Product product = new Product();
        String viewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).create(product);
    }

    @Test
    public void testProductListPage() {
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);

        String viewName = productController.productListPage(model);

        assertEquals("productList", viewName);
        verify(model, times(1)).addAttribute("products", productList);
    }

    @Test
    public void testEditProductPage() {
        String productId = "123";
        Product product = new Product();
        when(productService.findById(productId)).thenReturn(product);

        String viewName = productController.editProductPage(productId, model);

        assertEquals("editProduct", viewName);
        verify(model, times(1)).addAttribute("product", product);
    }

    @Test
    public void testEditProductPost() {
        Product product = new Product();
        String viewName = productController.editProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).update(product.getProductId(), product);
    }

    @Test
    public void testDeleteProduct() {
        String productId = "123";
        String viewName = productController.deleteProduct(productId);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).deleteProductById(productId);
    }
}
