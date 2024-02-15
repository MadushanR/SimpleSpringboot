package com.example.Assignment1;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.Assignment1.Model.Order;
@Service
public class OrderService {


    List<Order> orders = new ArrayList<Order>();
    public void save(Order order) {
        orders.add(order);
    }
    public List<Order> getOrders(){
        return orders;
    }

}
