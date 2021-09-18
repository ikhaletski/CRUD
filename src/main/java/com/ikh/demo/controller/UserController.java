package com.ikh.demo.controller;

import com.ikh.demo.model.User;
import com.ikh.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Operation(summary = "Lists all users", description = "Show list of user with such parameters: Id, First name, last name")
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }
    @Operation(summary = "Created user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User class", required = true, content = @Content(schema = @Schema(implementation = User.class)))
    @PostMapping(value="/users")
    public void createUser(@RequestBody Optional<User> user) {
        if(user.isPresent()) {
            userService.add(user.get());
        }
    }

    @Operation(summary = "Update user", description = "Updates the user found by id")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User class", required = true, content = @Content(schema = @Schema(implementation = User.class)))
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Optional<User> user) {
        if(user.isPresent()) {
            user.get().setId(id);
            userService.add(user.get());
        }
    }

    @Operation(summary = "Delete user", description = "Deletes user found by id")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }


}
