package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Car;

public interface CarRetrievalService {
    List<Car> findAll();
    Car findById(String id);
}
