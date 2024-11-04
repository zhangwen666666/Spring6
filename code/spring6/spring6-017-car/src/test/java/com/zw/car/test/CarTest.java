package com.zw.car.test;

import com.zw.car.pojo.Car;
import com.zw.car.service.CarService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CarTest {
    @Test
    public void testGetById() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService carService = applicationContext.getBean("carService", CarService.class);
        Car car = carService.getCarById(1);
        System.out.println(car);
    }

    @Test
    public void testGetAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService carService = applicationContext.getBean("carService", CarService.class);
        List<Car> cars = carService.getCars();
        cars.forEach(System.out::println);
    }

    @Test
    public void testSave() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService carService = applicationContext.getBean("carService", CarService.class);
        int count = carService.save(new Car(null, "1005", "混动车", "2024-5-12", "红旗", 16.3));
        System.out.println(count);
    }

    @Test
    public void testDeleteById() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService carService = applicationContext.getBean("carService", CarService.class);
        int count = carService.deleteById(1);
        System.out.println(count);
    }

    @Test
    public void testModify() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService carService = applicationContext.getBean("carService", CarService.class);
        int count = carService.modify(new Car(2, "1002", "燃油车", "2019-7-14", "保时捷", 70.8));
        System.out.println(count);
    }

    @Test
    public void testTransfer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService carService = applicationContext.getBean("carService", CarService.class);
        try {
            carService.transfer(4, 5, 10.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
