package com.zw.car.mapper;

import com.zw.car.pojo.Car;

import java.util.List;

public interface CarMapper {

    int insert(Car car);
    int deleteById(int id);
    int update(Car car);
    Car selectById(int id);
    List<Car> selectAll();
}
