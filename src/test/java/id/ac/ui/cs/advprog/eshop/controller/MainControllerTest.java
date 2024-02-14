package id.ac.ui.cs.advprog.eshop.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMain() {
        String viewName = mainController.getMain();
        assertEquals("homePage", viewName);
    }
}

