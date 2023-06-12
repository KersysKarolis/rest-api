package com.example.restapiexample.controller;

import com.example.restapiexample.entity.Car;
import com.example.restapiexample.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;
    @GetMapping
    public List<Car> getAllCars(){
        return this.carService.getAllCars();
    }
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable("id") Long id){
        return this.carService.getCarById(id);

    }
    @PostMapping
    public Car addCar(@RequestBody Car car){
        return this.carService.addCar(car);
    }
    @DeleteMapping("/{id}")
    public Car deleteCarById(@PathVariable Long id) {
        return this.carService.deleteCarById(id);
    }
    @PutMapping("/{id}")
    public List<Car> updateCarById(@PathVariable Long id, @RequestBody Car car) throws Exception {
        return this.carService.replaceCarById(id,car);
    }
    @PatchMapping("/{id}")
    public List<Car> patchStudentById(@PathVariable Long id, @RequestBody Car car){
        return this.carService.patchCarById(id, car);
    }
}
