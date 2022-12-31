package com.driver.io.Converter;

import java.util.UUID;

import com.driver.io.entity.FoodEntity;
import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.shared.dto.FoodDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FoodConverter {
    
    public static FoodDto convertEntityToDto(FoodEntity food) {
        FoodDto foodDto=  FoodDto.builder()
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .foodPrice(food.getFoodPrice())
                .foodCategory(food.getFoodCategory())
                .id(food.getId())
                .build();
        return foodDto;
    }
    public static FoodEntity convertDtoToEntity(FoodDto food){
        FoodEntity foodEntity= FoodEntity.builder()
                .foodName(food.getFoodName())
                .id(food.getId())
                .foodCategory(food.getFoodCategory())
                .foodPrice(food.getFoodPrice())
                .foodId(food.getFoodId())
                .build();
        return foodEntity;
    }
    public static FoodDto foodRequestToDto(FoodDetailsRequestModel foodDetailsRequestModel)
    {
        FoodDto foodDto = FoodDto.builder()
                .foodName(foodDetailsRequestModel.getFoodName())
                .foodPrice(foodDetailsRequestModel.getFoodPrice())
                .foodCategory(foodDetailsRequestModel.getFoodCategory())
                .foodId(UUID.randomUUID().toString()).build();
        return foodDto;
    }
    public static FoodDetailsResponse dtoToResponse(FoodDto foodDto)
    {
        FoodDetailsResponse foodDetailsResponse = FoodDetailsResponse.builder()
                .foodName(foodDto.getFoodName())
                .foodPrice(foodDto.getFoodPrice())
                .foodCategory(foodDto.getFoodCategory())
                .foodId(foodDto.getFoodId())
                .build();
        return  foodDetailsResponse;
    }
}
