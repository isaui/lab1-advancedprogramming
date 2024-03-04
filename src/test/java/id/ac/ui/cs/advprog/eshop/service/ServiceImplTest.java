package id.ac.ui.cs.advprog.eshop.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.impl.ProductCreationServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.impl.ProductDeletionServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.impl.ProductModificationServiceImpl;
import id.ac.ui.cs.advprog.eshop.service.impl.ProductRetrievalServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceImplTest {
    @InjectMocks
    ProductCreationServiceImpl productCreationServiceImpl;
    @InjectMocks
    ProductDeletionServiceImpl productDeletionServiceImpl;
    @InjectMocks
    ProductModificationServiceImpl productModificationServiceImpl;
    @InjectMocks
    ProductRetrievalServiceImpl productRetrievalServiceImpl;
    @Mock
    ProductRepository productRepository; 
    @BeforeEach
    void setup(){
        
    }
    @Test
    void testCreate() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(any(Product.class))).thenReturn(product);
        when(productRepository.findById(product.getProductId())).thenReturn(product);
        
        productCreationServiceImpl.create(product);
        Product savedProduct = productRetrievalServiceImpl.findById(product.getProductId());
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }
    @Test
    void testFindAll() {
        // Arrange
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Product 1");
        product1.setProductQuantity(10);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Product 2");
        product2.setProductQuantity(20);

        List<Product> productList = Arrays.asList(product1, product2);

        // Stubbing
        when(productRepository.findAll()).thenReturn(productList.iterator());

        // Act
        List<Product> foundProducts = productRetrievalServiceImpl.findAll();

        // Assert
        assertEquals(2, foundProducts.size());
        assertEquals(product1.getProductId(), foundProducts.get(0).getProductId());
        assertEquals(product1.getProductName(), foundProducts.get(0).getProductName());
        assertEquals(product1.getProductQuantity(), foundProducts.get(0).getProductQuantity());

        assertEquals(product2.getProductId(), foundProducts.get(1).getProductId());
        assertEquals(product2.getProductName(), foundProducts.get(1).getProductName());
        assertEquals(product2.getProductQuantity(), foundProducts.get(1).getProductQuantity());
    }

    @Test
    void testUpdate() {
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";
        Product productToUpdate = new Product();
        productToUpdate.setProductId(productId);
        productToUpdate.setProductName("Product Name");
        productToUpdate.setProductQuantity(200);
        when(productRepository.create(any(Product.class))).thenReturn(productToUpdate);
        productCreationServiceImpl.create(productToUpdate);
        productModificationServiceImpl.update(productId, productToUpdate);
        verify(productRepository).update(eq(productId), eq(productToUpdate));
    }

    @Test
    void testDeleteProductById() {
        // Arrange
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";

        // Act
        productDeletionServiceImpl.deleteProductById(productId);

        // Assert
        verify(productRepository, times(1)).delete(productId);
    }
}
