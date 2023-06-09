package com.example.ModelMapperDemo.service;

import com.example.ModelMapperDemo.model.Employee;
import com.example.ModelMapperDemo.model.UserRequest;
import com.example.ModelMapperDemo.model.UserResponse;

public interface UserService {

    UserResponse saveUser(UserRequest request);

    Employee getEmployeeResponse(UserRequest request);
}
