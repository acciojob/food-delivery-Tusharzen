package com.driver.io.Converter;

import java.util.UUID;

import com.driver.io.entity.OrderEntity;
import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.shared.dto.OrderDto;

public class OrderConverter {
    
    // public static OrderEntity ConvertRequestToEntity(OrderDetailsRequestModel order) {
    //     return OrderEntity.builder()
    //             .userId(order.getUserId())
    //             .items(order.getItems())
    //             .cost(order.getCost())
    //             .status(false)
    //            .build();
    // }

    public static OrderDto convertEntityToDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                .orderId(orderEntity.getOrderId())
                .cost(orderEntity.getCost())
                .items(orderEntity.getItems())
                .userId(orderEntity.getUserId())
                .status(orderEntity.isStatus())
                .build();
    }

    public static OrderDetailsResponse convertDtoToResponse(OrderDto orderDto) {
        return OrderDetailsResponse.builder()
                .orderId(orderDto.getOrderId())
                .cost(orderDto.getCost())
                .items(orderDto.getItems())
                .userId(orderDto.getUserId())
                .status(orderDto.isStatus())
                .build();
    }
    public static OrderDto orderRequestToDto(OrderDetailsRequestModel orderDetailsRequestModel)
    {
        OrderDto orderDto = OrderDto.builder()
                .orderId(UUID.randomUUID().toString())
                .cost(orderDetailsRequestModel.getCost())
                .items(orderDetailsRequestModel.getItems())
                .userId(orderDetailsRequestModel.getUserId())
                .status(true)
                .build();
        return orderDto;
    }

    public static OrderEntity convertDtoToEntity(OrderDto order) {
        OrderEntity orderEntity = OrderEntity.builder()
        .orderId(order.getOrderId())
        .userId(order.getUserId())
        .cost(order.getCost())
        .items(order.getItems())
        .status(order.isStatus())
        .build();
        return orderEntity ;
    }

}
