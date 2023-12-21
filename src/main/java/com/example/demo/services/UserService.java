package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getUserByID(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getUsersByPriority(Integer priority){
        return userRepository.findAllByPriority(priority);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserModel updateUserByID(UserModel updatedUser, Long id){
        Optional<UserModel> databaseUser = userRepository.findById(id);
        updatedUser.setId(databaseUser.get().getId());
        return userRepository.save(updatedUser);
    }
}
