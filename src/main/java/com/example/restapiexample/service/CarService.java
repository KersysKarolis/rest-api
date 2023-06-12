package com.example.restapiexample.service;

import com.example.restapiexample.entity.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> carList = new ArrayList<>();

    public void addTestCar(){
       carList.add(new Car(1L, "Bmw", "E91" , "mnamna", 2000));
       carList.add(new Car(2L, "Audi", "A6" , "gosgos", 2500));
        carList.add(new Car(3L, "Bmw", "E61" , "aaamna", 3000));
        carList.add(new Car(4L, "Bmw", "E81" , "nnamna", 4000));
    }
    public List<Car> getAllCars (){
        if (carList.isEmpty()) {
            addTestCar();
        }
        return carList;


    }
    public Car addCar (Car car){
       this.carList.add(car);
       return car;
    }
    public Car deleteCarById (Long id){
     Car carToDelete = carList.stream().filter(car -> car.getId().equals(id)).findFirst().orElseThrow();
     carList.remove(carToDelete);
     return carToDelete;
    }
    public Car getCarById (Long id){
    return carList.stream().filter(car -> car.getId().equals(id)).findFirst().orElseThrow();
    }
    public List<Car> replaceCarById (Long id, Car car){
        Car carToReplace = getCarById(id);
        int indexToReplace = this.carList.indexOf(carToReplace);
        this.carList.set(indexToReplace, carToReplace);
        return this.carList;
    }
    public List<Car> patchCarById (Long id, Car car){
        Car carToPatch = getCarById(id);
        if(car.getId() != null){
            carToPatch.setId(car.getId());
        }
        if(car.getMake() != null){
            carToPatch.setMake(car.getMake());
        }
        if(car.getModel() != null){
            carToPatch.setModel(car.getModel());
        }
        if(car.getPlate() != null){
            carToPatch.setPlate(car.getPlate());
        }
        if(car.getDisplacement() != null){
            carToPatch.setDisplacement(car.getDisplacement());
        }
        int indexOfCar = this.carList.indexOf(carToPatch);
        this.carList.set(indexOfCar, carToPatch);
        return this.carList;
    }
}
