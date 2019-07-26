package kz.test.car;

import kz.test.car.model.Car;
import kz.test.car.model.form.CarForm;
import kz.test.car.repos.CarRepo;
import kz.test.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import  java.util.Map;
import java.util.Optional;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars/list")
    public String listCars(Model model){
        model.addAttribute("cars", carService.getAll());
        return "main";
    }

    @PostMapping("/cars/add")
    public String addCar(CarForm carForm){

        carService.addCar(carForm);
        return "redirect:/cars/list";
    }

    @PostMapping("/cars/filter")
    public String filter(CarForm carForm, Model model){

        model.addAttribute("cars", carService.findCar(carForm));
        return "/cars/filter";
    }

    @PostMapping("/cars/delete")
    public String delete(CarForm carForm){

        carService.deleteCar(carForm);
        return "redirect:/cars/list";
    }

    @PostMapping("/cars/update")
    public String update(CarForm carForm){

        carService.deleteCar(carForm);
        return "redirect:/cars/list";
    }

}
