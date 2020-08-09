package com.rmit.sept.turtorial.demo.services;


import com.rmit.sept.turtorial.demo.Repositories.UserRepository;
import com.rmit.sept.turtorial.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveOrUpdatePerson(User user) {

        //logic
        return userRepository.save(user);
    }

    //Load user using userId and then do the authentication

    public User loadUserId(long userId) {
        final Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.get();
    }

    //Register the user with the required credentials
//    void signUserUp(User user){
//
////        String encryptPassword = bCryptPasswordEncoder.encode(user.getPassword());
//
//        //Use encrypt password rather than the original one
//
//        final User createdUser = saveOrUpdatePerson(user);
//
//
//    }
}