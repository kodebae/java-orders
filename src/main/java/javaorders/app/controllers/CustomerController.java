package javaorders.app.controllers;

import javaorders.app.models.Customer;
import javaorders.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders")
    public ResponseEntity<?> listAllCustomers() {
        List<Customer> custList = customerService.findAllCustomers(); //connects to services calls it and returns it
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }

//  //http://localhost:2019/customers/customer/7
//    @GetMapping(value = "/customer/{id}", produces = "application/json")
//    public ResponseEntity<?> getCustId(@PathVariable long id) {
//        Customer findName = customerService.getCustId(id);
//        return new ResponseEntity<>(findName, HttpStatus.OK);
//    }

}
// this is where we create our endpoints and connect them to the respository
// 1 make a request
// 2 call something else to get the data
// 3 make a return
// http://localhost:2019/customers/orders
// http://localhost:2019/customers/customer/7
// http://localhost:2019/customers/customer/77
// http://localhost:2019/customers/namelike/mes
// http://localhost:2019/customers/namelike/cin

//controllers are only going to access services. We need to restrict what our controllers have access to.