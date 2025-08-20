package com.dio.spring_tests.welcome_controller.controller;

import com.dio.spring_tests.welcome_controller.dto.UserRecord;
import com.dio.spring_tests.welcome_controller.model.User;
import com.dio.spring_tests.welcome_controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/seeding")
    public List<User> seedingRepository() {
        User u1 = new User();
        User u2 = new User("gustaf.rickli", "bball8894");
        User u3 = new User("leo-rickli", "blablafoo");
        User u4 = new User("steven_spilberg", "niaumnaisdhfhg");
        User u5 = new User();

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);
        userRepository.save(u5);

        return userRepository.findAll();
    }

    @PostMapping
    public void postUser(@RequestBody UserRecord userRecord) {

        User user = new User(userRecord.login(), userRecord.password());

        userRepository.save(user);
    }



    @GetMapping()
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUserName(username).get();
    }

    @PutMapping("/{id}/{newUsername}")
    public String setNewUserLogin(@PathVariable Integer id, @PathVariable String newUsername) {

        if (!userRepository.findById(id).isPresent()) {
            return "Erro";
        }

        User user = userRepository.findById(id).get();

        user.setLogin(newUsername);
        userRepository.save(user);

        return "Sucesso";
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

}
