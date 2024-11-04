package com.zw.car.service.impl;

import com.zw.car.mapper.CarMapper;
import com.zw.car.pojo.Car;
import com.zw.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int save(Car car) {
        return carMapper.insert(car);
    }

    @Override
    public int deleteById(int id) {
        return carMapper.deleteById(id);
    }

    @Override
    public int modify(Car car) {
        return carMapper.update(car);
    }

    @Override
    public Car getCarById(int id) {
        return carMapper.selectById(id);
    }

    @Override
    public List<Car> getCars() {
        return carMapper.selectAll();
    }

    @Override
    public void transfer(int fromId, int toId, double money) {
        Car car1 = getCarById(fromId);
        Car car2 = getCarById(toId);
        if (car1 == null || car2 == null) {
            throw new RuntimeException("car不存在");
        }

        if (car1.getPrice() < money) {
            throw new RuntimeException("car1太便宜了，无法再降价这么多了");
        }

        car1.setPrice(car1.getPrice() - money);
        car2.setPrice(car2.getPrice() + money);

        int count = carMapper.update(car1);
        int i = 1/0;
        count += carMapper.update(car2);

        if (count != 2) {
            throw new RuntimeException("改价失败");
        }
    }
}
