package kz.test.car.controllers;

import kz.test.car.model.form.CarForm;
import kz.test.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping({"/adminPage", "/userPage"})
    public String listCars(Model model, @AuthenticationPrincipal User user){
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ADMIN")) {
                model.addAttribute("cars", carService.getAll());
                model.addAttribute("carForm", new CarForm());
                return "adminPage";
            }
            else if (authority.getAuthority().equals("USER")) {
                model.addAttribute("carForm", new CarForm());
                model.addAttribute("cars", carService.findUserCar(user));
                return "userPage";
            }
        }
        return "login";
    }

    @PostMapping({"/adminPage/addCar", "/userPage/addCar"})
    public String addCars(CarForm carForm, Model model, @AuthenticationPrincipal User user){
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ADMIN")) {
                carService.addCar(carForm);
                model.addAttribute("cars", carService.getAll());
                return "adminPage";
            }
            else if (authority.getAuthority().equals("USER")) {
                carForm.setCarFormOwnerName(user.getUsername());
                carService.addCar(carForm);
                model.addAttribute("cars", carService.findUserCar(user));
                return "userPage";
            }
        }
        return "login";
    }

    @GetMapping("/adminPage/findCar")
    public String filterCars(CarForm carForm, Model model, @AuthenticationPrincipal User user){
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ADMIN")) {
                model.addAttribute("cars", carService.findCar(carForm));
                return "adminPage";
            }
        }
        return "login";
    }

    @PostMapping({"/adminPage/deleteCar", "/userPage/deleteCar"})
    public String deleteCars(CarForm carForm, Model model, @AuthenticationPrincipal User user){
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ADMIN")) {
                carService.deleteCar(carForm);
                model.addAttribute("cars", carService.getAll());
                return "adminPage";
            }
            else if (authority.getAuthority().equals("USER")) {
                carService.deleteUserCar(carForm, user);
                model.addAttribute("cars", carService.findUserCar(user));
                return "userPage";
            }
        }
        return "login";
    }

    @PostMapping({"/adminPage/updateCar", "/userPage/updateCar"})
    public String updateCars(CarForm carForm, Model model, @AuthenticationPrincipal User user){
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ADMIN")) {
                carService.updateCar(carForm);
                model.addAttribute("cars", carService.getAll());
                return "adminPage";
            }
            else if (authority.getAuthority().equals("USER")) {
                carService.updateUserCar(carForm, user);
                model.addAttribute("cars", carService.findUserCar(user));
                return "userPage";
            }
        }
        return "login";
    }

}
