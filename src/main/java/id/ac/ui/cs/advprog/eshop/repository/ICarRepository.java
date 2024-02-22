package id.ac.ui.cs.advprog.eshop.repository;
import java.util.Iterator;
import id.ac.ui.cs.advprog.eshop.model.Car;

public interface ICarRepository {
    public Car create(Car car);
    public Iterator<Car> findAll();
    public Car findById(String id);
    public Car update(String id, Car updatedCar);
    public void delete(String id);
}
