package com.zw.car.service;

import com.zw.car.pojo.Car;

import java.util.List;

public interface CarService {
    int save(Car car);
    int deleteById(int id);
    int modify(Car car);
    Car getCarById(int id);
    List<Car> getCars();

    void transfer(int fromId, int toId, double money);
}
