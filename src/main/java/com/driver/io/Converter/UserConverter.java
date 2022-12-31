package com.driver.io.Converter;

import java.util.UUID;

import com.driver.io.entity.UserEntity;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.UserResponse;
import com.driver.shared.dto.UserDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    
    // public static UserEntity ConvertRequestToEntity(UserDetailsRequestModel user) {
    //     return UserEntity.builder()
    //             .email(user.getEmail())
    //             .firstName(user.getFirstName())
    //             .lastName(user.getLastName())
    //             .build();
    // }

    public static UserDto userRequestToDto(UserDetailsRequestModel userDetailsRequestModel) throws Exception
    {
        UserDto userDto = UserDto.builder()
                .firstName(userDetailsRequestModel.getFirstName())
                .lastName(userDetailsRequestModel.getLastName())
                .email(userDetailsRequestModel.getEmail())
                .userId(UUID.randomUUID().toString())
                .build();
        return userDto;
    }
    
    public static UserDto convertEntityToDto(UserEntity userEntity) {
       return UserDto.builder()
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .build();
    }
    public static UserResponse convertDtoToResponse(UserDto userDto) {
        return UserResponse.builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }
    
    public static UserEntity convertDtoToEntity(UserDto user){
        return  UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .userId(user.getUserId())
                .build();
    }
}
