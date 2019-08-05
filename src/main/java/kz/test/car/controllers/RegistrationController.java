package kz.test.car.controllers;

import kz.test.car.domain.Form.UserForm;
import kz.test.car.domain.Role;
import kz.test.car.domain.User;
import kz.test.car.repos.UserRepo;
import kz.test.car.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserForm userForm, Model model){
        if(registrationService.findUser(userForm) != null){
            model.addAttribute("message", "User already exists!");
            return "registration";
        }

        registrationService.addUser(userForm, model);
        return "redirect:/login";
    }
}
