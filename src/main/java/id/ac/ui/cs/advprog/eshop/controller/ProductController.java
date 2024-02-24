package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductCreationService;
import id.ac.ui.cs.advprog.eshop.service.ProductDeletionService;
import id.ac.ui.cs.advprog.eshop.service.ProductModificationService;
import id.ac.ui.cs.advprog.eshop.service.ProductRetrievalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired ProductCreationService productCreationService;
    @Autowired ProductDeletionService productDeletionService;
    @Autowired ProductModificationService productModificationService;
    @Autowired ProductRetrievalService productRetrievalService;
    String PRODUCT_LIST_URL_REDIRECT = "redirect:list";

    @GetMapping("/create")
    public String createProductPage(Model model) {
       Product product = new Product();
       model.addAttribute("product", product);
       return "CreateProduct";
    }
    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        productCreationService.create(product);
        return PRODUCT_LIST_URL_REDIRECT;
    }
    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = productRetrievalService.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = productRetrievalService.findById(productId);
        model.addAttribute("product", product);
        return "EditProduct";
    }
    @PostMapping("/edit")
    public String editProductPost( @ModelAttribute Product product, Model model) {
        productModificationService.update(product.getProductId(), product);
        return PRODUCT_LIST_URL_REDIRECT;
    }
    
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId) {
        productDeletionService.deleteProductById(productId);
        return PRODUCT_LIST_URL_REDIRECT;
    }
}