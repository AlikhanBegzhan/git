package kz.test.car.service;

import kz.test.car.domain.Form.UserForm;
import kz.test.car.domain.Role;
import kz.test.car.domain.User;
import kz.test.car.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private UserRepo userRepo;

    public User findUser(UserForm userForm){

        User userFromDb = userRepo.findByUsername(userForm.getUsername());
        return userFromDb;
    }

    public void addUser(UserForm userForm, Model model){

        userForm.setActive(true);
        if("USER".equals(userForm.getRoles())){
            userForm.setRoles(Collections.singleton(Role.USER));
        }
        else if("ADMIN".equals(userForm.getRoles())){
            userForm.setRoles(Collections.singleton(Role.ADMIN));
        }
        User user = new User(userForm.getUsername(), userForm.getPassword(), userForm.isActive(), userForm.getRoles());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    public void deleteUser(UserForm userForm){

        userRepo.deleteById(userForm.getId());
    }

    public void updateUser(UserForm userForm){

        Optional<User> user1 = userRepo.findById(userForm.getId());
        User user = user1.get();

        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        user.setActive(userForm.isActive());
        user.setRoles(userForm.getRoles());

        userRepo.save(user);
    }
}
