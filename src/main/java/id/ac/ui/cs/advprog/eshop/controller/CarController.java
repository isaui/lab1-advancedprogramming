package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarCreationService;
import id.ac.ui.cs.advprog.eshop.service.CarDeletionService;
import id.ac.ui.cs.advprog.eshop.service.CarModificationService;
import id.ac.ui.cs.advprog.eshop.service.CarRetrievalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/car")
class CarController extends ProductController{

    @Autowired CarCreationService carCreationService;
    @Autowired CarDeletionService carDeletionService;
    @Autowired CarModificationService carModificationService;
    @Autowired CarRetrievalService carRetrievalService;
    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CreateCar";
    }
    @PostMapping("/createCar")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        carCreationService.create(car);
        return "redirect:listCar";
    }
    @GetMapping("/listCar")
    public String carListPage(Model model) {
        List<Car> allCars = carRetrievalService.findAll();
        model.addAttribute("cars", allCars);
        return "CarList";
    }
    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = carRetrievalService.findById(carId);
        model.addAttribute("car", car);
        return "EditCar";
    }
    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        carModificationService.update( car.getCarId(), car);
        return "redirect:listCar";
    }
    @PostMapping("/deleteCar")
    public String deleteCarPost(@RequestParam("carId") String carId) {
        carDeletionService.deleteCarById(carId);
        return "redirect:listCar";
    }
}
