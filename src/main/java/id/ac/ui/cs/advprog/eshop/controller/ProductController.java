package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;



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
       return "createProduct";
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
        return "productList";
    }
    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "editProduct";
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
