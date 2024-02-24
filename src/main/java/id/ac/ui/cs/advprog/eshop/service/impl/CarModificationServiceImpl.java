package id.ac.ui.cs.advprog.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.ICarRepository;
import id.ac.ui.cs.advprog.eshop.service.CarModificationService;

@Service
public class CarModificationServiceImpl implements CarModificationService {
    @Autowired
    private ICarRepository carRepository;
    @Override
    public void update(String carId, Car car) {
        carRepository.update(carId, car);
    }
}
