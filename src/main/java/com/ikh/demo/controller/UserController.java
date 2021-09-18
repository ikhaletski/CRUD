package com.ikh.demo.controller;

import com.ikh.demo.model.User;
import com.ikh.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value="/users")
    public void createUser(@RequestBody Optional<User> user) {
        if(user.isPresent()) {
            userService.add(user.get());
        }
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Optional<User> user) {
        if(user.isPresent()) {
            user.get().setId(id);
            userService.add(user.get());
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }


}
