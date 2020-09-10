package javaorders.app.controllers;

import javaorders.app.models.Customer;
import javaorders.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //http://localhost:2019/customers/orders
    @GetMapping(value = "/customers", produces = "application/json")
    public ResponseEntity<?> listAllCustomers() {
        List<Customer> custList = customerService.findAllCustomers(); //connects to services calls it and returns it
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }

  //http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{id}", produces = "application/json")
    public ResponseEntity<?> getCustId(@PathVariable long id) {
        Customer findName = customerService.getCustId(id);
        return new ResponseEntity<>(findName, HttpStatus.OK);
    }

}
// this is where we create our endpoints and connect them to the respository