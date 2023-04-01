package com.example.ModelMapperDemo.controller;

import com.example.ModelMapperDemo.model.Employee;
import com.example.ModelMapperDemo.model.UserRequest;
import com.example.ModelMapperDemo.model.UserResponse;
import com.example.ModelMapperDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserResponse saveUser(@RequestBody UserRequest request){
        return userService.saveUser(request);
    }

    @PostMapping("/employee")
    public Employee getEmployeeResponse(@RequestBody UserRequest request){
        return userService.getEmployeeResponse(request);
    }
}
