package id.ac.ui.cs.advprog.eshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Product;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setup(){

    }

    @Test
    void testCreate_ProductIdIsNull() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(100);

        // Act
        Product createdProduct = productRepository.create(product);

        // Assert
        assertNotNull(createdProduct.getProductId());
        assertEquals(product.getProductName(), createdProduct.getProductName());
        assertEquals(product.getProductQuantity(), createdProduct.getProductQuantity());
    }

    @Test
    void testFindById_ProductExists() {
        // Arrange
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";
        Product expectedProduct = new Product();
        expectedProduct.setProductId(productId);
        // Add the expectedProduct to productData list
        productRepository.create(expectedProduct);

        // Act
        Product actualProduct = productRepository.findById(productId);

        // Assert
        assertNotNull(actualProduct);
        assertEquals(expectedProduct.getProductId(), actualProduct.getProductId());
    }

    @Test
    void testFindById_ProductDoesNotExist() {
        // Arrange
        String nonExistentProductId = "non-existent-product-id";
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";
        Product expectedProduct = new Product();
        expectedProduct.setProductId(productId);
        // Add the expectedProduct to productData list
        productRepository.create(expectedProduct);

        // Act
        Product actualProduct = productRepository.findById(nonExistentProductId);

        // Assert
        assertNull(actualProduct);
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), product.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    public void testDeletePositive() {
        Product product1 = new Product();
        product1.setProductId("to-delete-1");
        product1.setProductName("to-delete-product-name");
        product1.setProductQuantity(10);
        productRepository.create(product1);
        assertEquals(1, getProductObjectCount(productRepository.findAll()));
        productRepository.delete("to-delete-1");
        assertNull(productRepository.findById("to-delete-1"));
        assertTrue(0 == getProductObjectCount(productRepository.findAll()));
    }

    @Test
    public void testDeleteNegative() {
        Product product1 = new Product();
        product1.setProductId("to-delete-1");
        product1.setProductName("to-delete-product-name");
        product1.setProductQuantity(10);
        productRepository.create(product1);
        assertEquals(1, getProductObjectCount(productRepository.findAll()));
        productRepository.delete("non-existent-id");
        assertEquals(1, getProductObjectCount(productRepository.findAll()));
    }


    @Test
    public void testEditPositive(){
        Product initialProduct = new Product();
        initialProduct.setProductId("to-update-1");
        initialProduct.setProductName("to-update-product-name");
        initialProduct.setProductQuantity(10);
        productRepository.create(initialProduct);

        Product updatedProduct = new Product();
        updatedProduct.setProductId(initialProduct.getProductId());
        updatedProduct.setProductName("to-update-product-name-update");
        updatedProduct.setProductQuantity(12);
        productRepository.update(updatedProduct.getProductId(), updatedProduct);
        assertEquals(updatedProduct.getProductName(), productRepository.findById(updatedProduct.getProductId()).getProductName());
        assertEquals(updatedProduct.getProductQuantity(),productRepository.findById(updatedProduct.getProductId()).getProductQuantity());
    }

    @Test
    public void testEditNegative(){
        Product initialProduct = new Product();
        initialProduct.setProductId("to-update-1");
        initialProduct.setProductName("to-update-product-name");
        initialProduct.setProductQuantity(10);
        productRepository.create(initialProduct);
        Product updatedProduct = new Product();
        updatedProduct.setProductId(initialProduct.getProductId());
        updatedProduct.setProductName("to-update-product-name-update");
        updatedProduct.setProductQuantity(12);
        productRepository.update("non-existent-id", updatedProduct);
        assertNotEquals(updatedProduct.getProductName(), productRepository.findById(updatedProduct.getProductId()).getProductName());
        assertNotEquals(updatedProduct.getProductQuantity(),productRepository.findById(updatedProduct.getProductId()).getProductQuantity());
    }
    
    private int getProductObjectCount(Iterator<Product> iterator){
        int productCount = 0;
        while (iterator.hasNext()) {
            iterator.next();
            productCount++;
        }
        return productCount;
    }

    



}
