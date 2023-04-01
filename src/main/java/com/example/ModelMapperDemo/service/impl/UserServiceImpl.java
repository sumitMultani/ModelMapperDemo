package com.example.ModelMapperDemo.service.impl;

import com.example.ModelMapperDemo.entity.UserEntity;
import com.example.ModelMapperDemo.model.Employee;
import com.example.ModelMapperDemo.model.UserRequest;
import com.example.ModelMapperDemo.model.UserResponse;
import com.example.ModelMapperDemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponse saveUser(UserRequest request) {
        UserEntity userEntity = convertUserRequestToUserEntity(request);
        UserEntity entityRes  = save(userEntity);
        UserResponse userResponse = convertUserEntityToUserResponse(entityRes);
        return userResponse;
    }

    @Override
    public Employee getEmployeeResponse(UserRequest request) {
        UserEntity userEntity = convertUserRequestToUserEntity(request);
        UserEntity entityRes  = save(userEntity);
        Employee employeeRes = convertUserEntityToEmployeeResponse(entityRes);
        return employeeRes;
    }

    public UserEntity convertUserRequestToUserEntity(UserRequest userRequest){
        return modelMapper.map(userRequest, UserEntity.class);
    }

    public UserResponse convertUserEntityToUserResponse(UserEntity userEntity){
        return modelMapper.map(userEntity, UserResponse.class);
    }

    public Employee convertUserEntityToEmployeeResponse(UserEntity userEntity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<UserEntity, Employee> typeMap = modelMapper.createTypeMap(UserEntity.class, Employee.class);
        typeMap.addMappings(new PropertyMap<UserEntity, Employee>() {
            @Override
            protected void configure() {
                map().setEmployeeAge(source.getAge());
                map().setEmployeeName(source.getName());
            }
        });
        Employee employee = this.modelMapper.map(userEntity, Employee.class);
        return employee;
    }

    private UserEntity save(UserEntity userEntity) {
        return userEntity;
    }
}
