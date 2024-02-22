package id.ac.ui.cs.advprog.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.ICarRepository;

@Service
public class CarModificationServiceImpl implements CarModificationService {
    @Autowired
    private ICarRepository carRepository;
    @Override
    public void update(String carId, Car car) {
        carRepository.update(carId, car);
    }
}
