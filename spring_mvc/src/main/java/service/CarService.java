package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public static List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", 333, 123));
        cars.add(new Car("BMW", 334, 124));
        cars.add(new Car("BMW", 335, 125));

        return cars;
    }
}
