package kz.test.car.service;

import kz.test.car.model.Car;
import kz.test.car.model.form.CarForm;
import kz.test.car.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public List<CarForm> getAll(){
        List<Car> cars = (List<Car>) carRepo.findAll();
//        return cars.stream()
//                .map(c -> new CarForm(c.getId(), c.getCarModel(), c.getCarYear(),
//                c.getCarMileage(), c.getCarOwnerName(), c.getCarOwnerNumber(),
//                c.getCarOwnerAddress(), c.getCarMasterName(), c.getCarMasterWork()))
//                .collect(Collectors.toList());
        List<CarForm> forms = new ArrayList<>();
        for(Car c : cars) {
            CarForm form = new CarForm(c.getId(), c.getCarModel(), c.getCarYear(),
                    c.getCarMileage(), c.getCarOwnerName(), c.getCarOwnerNumber(),
                    c.getCarOwnerAddress(), c.getCarMasterName(), c.getCarMasterWork());
            forms.add(form);
        }
        return forms;
    }

    public void addCar(CarForm carForm) {
        Car car = new Car(carForm.getCarModel(), carForm.getCarYear(), carForm.getCarMileage(), carForm.getCarOwnerName(),
                carForm.getCarOwnerNumber(), carForm.getCarOwnerAddress(), carForm.getCarMasterName(), carForm.getCarMasterWork());
        carRepo.save(car);
    }

    public CarForm findCar(CarForm carForm){
        Car car = carRepo.findByCarOwnerName(carForm.getCarOwnerName());
        CarForm carFound = null;

        if(carForm != null){
            carFound = new CarForm(car.getId(), car.getCarModel(), car.getCarYear(),
                    car.getCarMileage(), car.getCarOwnerName(), car.getCarOwnerNumber(),
                    car.getCarOwnerAddress(), car.getCarMasterName(), car.getCarMasterWork());
        } else{
            getAll();
        }

        return carFound;
    }

    public void deleteCar(CarForm carForm){
        Car car = carRepo.findByCarOwnerName(carForm.getCarOwnerName());

        if(carForm != null){
            carRepo.delete(car);
        }
    }

    public void update(CarForm carForm){

        Car car = carRepo.findByCarOwnerName(carForm.getCarOwnerName());

        if(carForm != null) {
            car.setId(carForm.getId());
            car.setCarModel(carForm.getCarModel());
            car.setCarYear(carForm.getCarYear());
            car.setCarMileage(carForm.getCarMileage());
            car.setCarOwnerName(carForm.getCarOwnerName());
            car.setCarOwnerNumber(carForm.getCarOwnerNumber());
            car.setCarOwnerAddress(carForm.getCarOwnerAddress());
            car.setCarMasterName(carForm.getCarMasterName());
            car.setCarMasterWork(carForm.getCarMasterWork());
        }

        carRepo.save(car);
    }
}
