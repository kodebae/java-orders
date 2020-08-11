package javaorders.day1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
​
@Order(value = "orderService")
public class RestaurantServiceImpl implements OrderService
{
    @Autowired
    OrderRepository restrepos;

}