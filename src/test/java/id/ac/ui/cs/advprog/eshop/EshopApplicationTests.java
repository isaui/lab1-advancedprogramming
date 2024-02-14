package id.ac.ui.cs.advprog.eshop;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
         assertDoesNotThrow(() -> EshopApplication.main(new String[] {}));

    }
}


