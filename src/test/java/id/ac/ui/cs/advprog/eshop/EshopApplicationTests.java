package id.ac.ui.cs.advprog.eshop;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
class EshopApplicationTests {

    @Autowired
    private EshopApplication eshopApplication;


    @Test
    void contextLoads() {
        assertNotNull(eshopApplication);
    }

    @Test
    void testSpringApplicationRun() {
        EshopApplication.main(new String[] {});

    }
}


