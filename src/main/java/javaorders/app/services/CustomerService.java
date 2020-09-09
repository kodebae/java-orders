package javaorders.app.services;

import javaorders.app.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Customer getCustId(long id);
}
