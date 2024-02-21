package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    String PRODUCT_LIST_URL_REDIRECT = "redirect:list";

    @GetMapping("/create")
    public String createProductPage(Model model) {
       Product product = new Product();
       model.addAttribute("product", product);
       return "CreateProduct";
    }
    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return PRODUCT_LIST_URL_REDIRECT;
    }
    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "EditProduct";
    }
    @PostMapping("/edit")
    public String editProductPost( @ModelAttribute Product product, Model model) {
        service.update(product.getProductId(), product);
        return PRODUCT_LIST_URL_REDIRECT;
    }
    
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId) {
        service.deleteProductById(productId);
        return PRODUCT_LIST_URL_REDIRECT;
    }

}

@Controller
@RequestMapping("/car")
class CarController extends ProductController{
    @Autowired
    private CarServiceImpl carservice;
    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CreateCar";
    }
    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        carservice.create(car);
        return "redirect:listCar";
    }
    @GetMapping("/listCar")
    public String carListPage(Model model) {
        List<Car> allCars = carservice.findAll();
        model.addAttribute("cars", allCars);
        return "CarList";
    }
    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = carservice.findById(carId);
        model.addAttribute("car", car);
        return "EditCar";
    }
    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        carservice.update( car.getCarId(), car);
        return "redirect:listCar";
    }
    @PostMapping("/deleteCar")
    public String deleteCarPost(@RequestParam("carId") String carId) {
        carservice.deleteCarById(carId);
        return "redirect:listCar";
    }
}