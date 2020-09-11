package javaorders.app.services;

import javaorders.app.models.Customer;
import javaorders.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/** Implements the CustomerServices Interface
 * treat everything that happens as a single transaction.
 * Every method that changes data gets this
 * If you have a method that is transactional the entire the class needs to be transactional. <---
 * Will stop the save method from working.
 * **/


@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {


    //connetcs the service to the Customer Table
    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    } // connects to CustomerController & CustomerService files

    @Override
    public Customer custcode(long id) {
        return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + "not found"));
    }
}


//