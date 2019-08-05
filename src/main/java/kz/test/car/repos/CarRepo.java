package kz.test.car.repos;

import kz.test.car.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Integer> {

    List<Car> findByCarOwnerName(String carOwnerName);
//    @Query(value="insert into car(S)", nativeQuery = true)
//    Car car findByCarMasterName(String masterName);
}

