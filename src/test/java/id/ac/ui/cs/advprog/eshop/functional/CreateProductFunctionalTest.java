package id.ac.ui.cs.advprog.eshop.functional;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductCreationService;
import id.ac.ui.cs.advprog.eshop.service.ProductDeletionService;
import id.ac.ui.cs.advprog.eshop.service.ProductModificationService;
import id.ac.ui.cs.advprog.eshop.service.ProductRetrievalService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;
    private String url;
    private String path = "/product/create";
    @Autowired
    private ProductCreationService productCreationService;
    @Autowired
    private ProductRetrievalService productRetrievalService;
    @Autowired
    private ProductDeletionService productDeletionService;
    @Autowired
    private ProductModificationService productModificationService;
    @BeforeEach
    void setupTest(){
        url = String.format("%s:%d%s", testBaseUrl, serverPort,path);
    }
    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(url);
        String pageTitle = driver.getTitle();
        assertEquals("Create New Product", pageTitle);
    }
    @Test
    void welcomeMessage_createProduct_isCorrect(ChromeDriver driver) throws Exception{
        driver.get(url);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();
        assertEquals("Create New Product", welcomeMessage);
    }
    
    @Test
void submitForm_createProduct_isSuccessful(ChromeDriver driver) throws Exception {
    driver.get(url);
    driver.findElement(By.id("nameInput")).sendKeys("New Product");
    driver.findElement(By.id("quantityInput")).sendKeys("10");
    driver.findElement(By.tagName("button")).click();
    List<Product> products = productRetrievalService.findAll();
    boolean isProductCreated = false;
    for (Product product : products) {
        if (product.getProductName().equals("New Product")) {
            isProductCreated = true;
            break;
        }
    }
    assertTrue(isProductCreated, "New product should be saved in the repository");
}

}
