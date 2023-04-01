package com.example.ModelMapperDemo.service.impl;

import com.example.ModelMapperDemo.entity.UserEntity;
import com.example.ModelMapperDemo.model.UserRequest;
import com.example.ModelMapperDemo.model.UserResponse;
import com.example.ModelMapperDemo.service.UserService;
import org.modelmapper.ModelMapper;
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

    public UserEntity convertUserRequestToUserEntity(UserRequest userRequest){
        return modelMapper.map(userRequest, UserEntity.class);
    }

    public UserResponse convertUserEntityToUserResponse(UserEntity userEntity){
        return modelMapper.map(userEntity, UserResponse.class);
    }

    private UserEntity save(UserEntity userEntity) {
        return userEntity;
    }
}
