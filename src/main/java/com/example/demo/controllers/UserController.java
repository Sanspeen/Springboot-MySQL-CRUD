package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-by-priority/{priority}")
    public ArrayList<UserModel> getUsersByPriority(@PathVariable Integer priority){
        return userService.getUsersByPriority(priority);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserByID(@PathVariable Long id){
        return userService.getUserByID(id);
    }



    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel body){
        return userService.saveUser(body);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel body, @PathVariable Long id){
        return userService.updateUserByID(body, id);
    }

}
