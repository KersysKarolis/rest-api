package com.example.restapiexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Car {
    private Long id;
    private String make;
    private String model;
    private String plate;
    private Integer displacement;

}
