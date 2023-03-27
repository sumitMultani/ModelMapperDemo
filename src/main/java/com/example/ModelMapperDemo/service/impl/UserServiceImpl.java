package com.example.ModelMapperDemo.service.impl;

import com.example.ModelMapperDemo.entity.UserEntity;
import com.example.ModelMapperDemo.model.UserRequest;
import com.example.ModelMapperDemo.model.UserResponse;
import com.example.ModelMapperDemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserResponse saveUser(UserRequest request) {
        UserEntity userEntity = convertUserRequestToUserEntity(request);
        UserEntity entityRes  = save(userEntity);
        UserResponse userResponse = convertUserEntityToUserResponse(entityRes);
        return userResponse;
    }

    public UserEntity convertUserRequestToUserEntity(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userRequest.getAge());
        userEntity.setId(userRequest.getId());
        userEntity.setName(userRequest.getName());
        return userEntity;
    }

    public UserResponse convertUserEntityToUserResponse(UserEntity userEntity){
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(userEntity.getAge());
        userResponse.setId(userEntity.getId());
        userResponse.setName(userEntity.getName());
        return userResponse;
    }

    private UserEntity save(UserEntity userEntity) {
        return userEntity;
    }
}
