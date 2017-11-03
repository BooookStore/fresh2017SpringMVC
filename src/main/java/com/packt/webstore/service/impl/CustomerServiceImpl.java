package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Customer> getCustomersByFilter(Map<String, List<String>> filter) {
        return customerRepository.getCustomersByFilter(filter);
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.getCustomerById(id);
    }
}
