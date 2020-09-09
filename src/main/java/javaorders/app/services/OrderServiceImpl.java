package javaorders.app.services;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javaorders.app.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//This is where we define what operations we will allow on our data

@JsonPropertyOrder(value = "orderService") // needed to name this implementation as the service to use
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersRepository ordernum;
    @Override
    public List<OrderService> getOrders() {
        return null;
    }

}


//
//@Service(value = "customerService")
//
//public class CustomerServiceImpl implements CustomerService {
//    @Autowired
//    private CustomerRepository custrepos;
//    @Override
//    public List<Customer> getOrders() {
//        return null;
//    }
//
//    @Override
//    public Customer getCustId(long id) {
//        return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + "not found"));
//    }
//}