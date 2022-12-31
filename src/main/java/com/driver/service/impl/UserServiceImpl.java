package com.driver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.io.Converter.UserConverter;
import com.driver.io.entity.UserEntity;
import com.driver.io.repository.UserRepository;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository ;

    @Override
    public UserDto createUser(UserDto user) throws Exception {
        // TODO Auto-generated method stub
        UserEntity userEntity = UserConverter.convertDtoToEntity(user);
        userRepository.save(userEntity);
        return UserConverter.convertEntityToDto(userEntity) ;
    }

    @Override
    public UserDto getUser(String email) throws Exception {
        // TODO Auto-generated method stub
        UserEntity userEntity = userRepository.findByEmail(email);
        UserDto userDto = UserConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        // TODO Auto-generated method stub
        UserEntity userEntity = userRepository.findByUserId(userId);
        UserDto userDto = UserConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) throws Exception {
        // TODO Auto-generated method stub
        UserEntity userEntity = userRepository.findByUserId(userId);
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userRepository.save(userEntity);

        UserDto userDto = UserConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public void deleteUser(String userId) throws Exception {
        // TODO Auto-generated method stub
        UserEntity userEntity = userRepository.findByUserId(userId);
        try
       {
           if(userEntity == null)
           {
               throw new Exception();
           }
       }
       catch (Exception e)
       {
           throw new Exception("user does not exist");
       }

       userRepository.deleteById(userEntity.getId());
        
    }

    @Override
    public List<UserDto> getUsers() {
        // TODO Auto-generated method stub
        List<UserEntity> userEntityList = (List<UserEntity>) userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(UserEntity userEntity : userEntityList)
        {
            UserDto userDto = UserConverter.convertEntityToDto(userEntity);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
    
}