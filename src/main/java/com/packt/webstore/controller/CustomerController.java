package com.packt.webstore.controller;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 顧客情報に対するコントローラ
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String list(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String getAddCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
        return "addCustomer";
    }
}
