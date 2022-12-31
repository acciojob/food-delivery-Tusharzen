package com.driver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.io.Converter.FoodConverter;
import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    FoodRepository foodRepository ;

    @Override
    public FoodDto createFood(FoodDto food) {
        // TODO Auto-generated method stub
        FoodEntity foodEntity = FoodConverter.convertDtoToEntity(food);
        foodRepository.save(foodEntity) ;
        return FoodConverter.convertEntityToDto(foodEntity);
    }

    @Override
    public FoodDto getFoodById(String foodId) throws Exception{
        // TODO Auto-generated method stub
        FoodEntity foodEntity = foodRepository.findByFoodId(foodId) ;
        FoodDto foodDto = FoodConverter.convertEntityToDto(foodEntity) ;
        return foodDto;
    }

    @Override
    public FoodDto updateFoodDetails(String foodId, FoodDto foodDetails) throws Exception {
        // TODO Auto-generated method stub
        FoodEntity foodEntity =  foodRepository.findByFoodId(foodId);
        foodEntity.setFoodCategory(foodDetails.getFoodCategory());
        foodEntity.setFoodName(foodDetails.getFoodName());
        foodEntity.setFoodPrice(foodDetails.getFoodPrice());

        foodRepository.save(foodEntity);
        FoodDto foodDto = FoodConverter.convertEntityToDto(foodEntity) ;
        return foodDto;
    }

    @Override
    public void deleteFoodItem(String id)  throws Exception{
        // TODO Auto-generated method stub
        FoodEntity foodEntity = foodRepository.findByFoodId(id);
        try
        {
            if(foodEntity == null)
            {
                throw  new Exception();
            }
        }
        catch (Exception e)
        {
            throw  new Exception("food not found");
        }
        foodRepository.deleteById(foodEntity.getId());
        
    }

    @Override
    public List<FoodDto> getFoods() {
        // TODO Auto-generated method stub
        List<FoodDto> foodDtoList = new ArrayList<>();
        List<FoodEntity> foodEntityList = (List<FoodEntity>)foodRepository.findAll();
        for(FoodEntity foodEntity : foodEntityList)
        {
            FoodDto foodDto = FoodConverter.convertEntityToDto(foodEntity);
            foodDtoList.add(foodDto);
        }
        return foodDtoList;
    }
    
}