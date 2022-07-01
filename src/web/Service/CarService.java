package web.Service;

import org.springframework.stereotype.Component;
import web.Model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("LADA", "VESTA", 2010));
        cars.add(new Car("BMW", "525", 2006));
        cars.add(new Car("KIA", "CERATO", 2017));
        cars.add(new Car("AUDI", "A6", 2012));
        cars.add(new Car("VOLKSWAGEN", "PASSAT", 2011));
    }

    public List<Car> showCars(long count) {
       if (count >= 5 || count <= 0) {
           return cars;
       }
       return cars.stream().limit(count).collect(Collectors.toList());
    }
}
