package kz.test.car.service;

import kz.test.car.domain.Role;
import kz.test.car.model.Car;
import kz.test.car.model.form.CarForm;
import kz.test.car.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public List<CarForm> getAll(){
        List<Car> cars = (List<Car>) carRepo.findAll();
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
        Car car = new Car(carForm.getCarFormModel(), carForm.getCarFormYear(), carForm.getCarFormMileage(),
                carForm.getCarFormOwnerName(), carForm.getCarFormOwnerNumber(), carForm.getCarFormOwnerAddress(),
                carForm.getCarFormMasterName(), carForm.getCarFormMasterWork());
        carRepo.save(car);
    }

    public List<CarForm> findCar(CarForm carForm){
        List<Car> cars = carRepo.findByCarOwnerName(carForm.getCarFormOwnerName());
        List<CarForm> carFound = new ArrayList<>();

        if(!"".equals(carForm.getCarFormOwnerName())){
            for (Car car : cars) {

                carFound.add(new CarForm(car.getId(), car.getCarModel(), car.getCarYear(),
                        car.getCarMileage(), car.getCarOwnerName(), car.getCarOwnerNumber(),
                        car.getCarOwnerAddress(), car.getCarMasterName(), car.getCarMasterWork()));
            }
        }else {
            carFound = getAll();
        }

        return carFound;
    }

    public void deleteCar(CarForm carForm){
        carRepo.deleteById(carForm.getCarFormId());
    }

    public void deleteUserCar(CarForm carForm, User user){

        Optional<Car> car1 = carRepo.findById(carForm.getCarFormId());
        Car car = car1.get();

        if(car.getCarOwnerName().equals(user.getUsername()))
            deleteCar(carForm);
    }

    public void updateCar(CarForm carForm){
        Optional<Car> car1 = carRepo.findById(carForm.getCarFormId());
        Car car = car1.get();

        if(!"".equals(carForm.getCarFormModel())){
            car.setCarModel(carForm.getCarFormModel());
        }
        if(!"".equals(carForm.getCarFormYear())){
            car.setCarYear(carForm.getCarFormYear());
        }
        if(carForm.getCarFormMileage() != null){
            car.setCarMileage(carForm.getCarFormMileage());
        }
        if(!"".equals(carForm.getCarFormOwnerName())){
            car.setCarOwnerName(carForm.getCarFormOwnerName());
        }
        if(!"".equals(carForm.getCarFormOwnerNumber())){
            car.setCarOwnerNumber(carForm.getCarFormOwnerNumber());
        }
        if(!"".equals(carForm.getCarFormOwnerAddress())){
            car.setCarOwnerAddress(carForm.getCarFormOwnerAddress());
        }
        if(!"".equals(carForm.getCarFormMasterName())){
            car.setCarMasterName(carForm.getCarFormMasterName());
        }
        if(!"".equals(carForm.getCarFormMasterWork())){
            car.setCarMasterWork(carForm.getCarFormMasterWork());
        }
        carRepo.save(car);
    }

    public void updateUserCar(CarForm carForm, User user){

        Optional<Car> car1 = carRepo.findById(carForm.getCarFormId());
        Car car = car1.get();

        if(car.getCarOwnerName().equals(user.getUsername())){
            carForm.setCarFormOwnerName(user.getUsername());
            updateCar(carForm);
        }
    }

    public List<CarForm> findUserCar(User user){

        List<Car> car = carRepo.findByCarOwnerName(user.getUsername());
        List<CarForm> carFound = new ArrayList<>();

        if(!"".equals(user.getUsername())){
            for(int i=0; i<car.size(); i++){

                carFound.add(new CarForm(car.get(i).getId(), car.get(i).getCarModel(), car.get(i).getCarYear(),
                        car.get(i).getCarMileage(), car.get(i).getCarOwnerName(), car.get(i).getCarOwnerNumber(),
                        car.get(i).getCarOwnerAddress(), car.get(i).getCarMasterName(), car.get(i).getCarMasterWork()));
            }
        }

        return carFound;
    }
}
