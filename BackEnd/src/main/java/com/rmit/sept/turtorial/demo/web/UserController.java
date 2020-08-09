package com.rmit.sept.turtorial.demo.web;

import com.rmit.sept.turtorial.demo.model.User;
import com.rmit.sept.turtorial.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createNewPerson(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()){
            return new ResponseEntity<String>("Invalid User Object", HttpStatus.BAD_REQUEST);
        }
        
        User user1 = userService.saveOrUpdatePerson(user);
        System.out.println(user1.getUsername());
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

}