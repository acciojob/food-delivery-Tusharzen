package com.driver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.io.Converter.OrderConverter;
import com.driver.io.entity.OrderEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository ;
    @Override
    public OrderDto createOrder(OrderDto order) {
        // TODO Auto-generated method stub
        OrderEntity orderEntity = OrderConverter.convertDtoToEntity(order) ;

        orderRepository.save(orderEntity);
        return OrderConverter.convertEntityToDto(orderEntity) ;
    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {
        // TODO Auto-generated method stub
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        OrderDto orderDto = OrderConverter.convertEntityToDto(orderEntity);
        return orderDto;
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        // TODO Auto-generated method stub
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        orderEntity.setCost(order.getCost());
        orderEntity.setItems(order.getItems());
        orderEntity.setStatus(order.isStatus());
        orderEntity.setUserId(order.getUserId());
        orderRepository.save(orderEntity);
        return OrderConverter.convertEntityToDto(orderEntity);
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
        // TODO Auto-generated method stub
        OrderEntity orderEntity= orderRepository.findByOrderId(orderId) ;
        try
        {
            if(orderEntity==null)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            throw new Exception("invalid order id");
        }
        orderRepository.deleteById(orderEntity.getId());
    }

    @Override
    public List<OrderDto> getOrders() {
        // TODO Auto-generated method stub
        List<OrderEntity> orderEntityList = (List<OrderEntity>) orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for(OrderEntity orderEntity : orderEntityList)
        {
            OrderDto orderDto = OrderConverter.convertEntityToDto(orderEntity);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
    
}