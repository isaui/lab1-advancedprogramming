package id.ac.ui.cs.advprog.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.ICarRepository;

@Service
class CarCreationServiceImpl implements CarCreationService {
    @Autowired
    private ICarRepository carRepository;
    @Override
    public Car create(Car car) {
        carRepository.create(car);
        return car;
    }
    
}