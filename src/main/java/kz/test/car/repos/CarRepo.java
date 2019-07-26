package kz.test.car.repos;

import kz.test.car.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Integer> {

    Car findByCarOwnerName(String carOwnerName);
}

