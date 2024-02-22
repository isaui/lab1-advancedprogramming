package id.ac.ui.cs.advprog.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.repository.ICarRepository;

@Service
public class CarDeletionServiceImpl implements CarDeletionService{
    @Autowired
    private ICarRepository carRepository;
    @Override
    public void deleteCarById(String carId) {
        carRepository.delete(carId);
    }
}
