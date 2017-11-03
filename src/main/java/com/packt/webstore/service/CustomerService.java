package com.packt.webstore.service;

import com.packt.webstore.domain.Customer;

import java.util.List;
import java.util.Map;

/**
 * 顧客情報に対する操作を定義
 */
public interface CustomerService {

    /**
     * 全ての顧客情報を取得する。
     *
     * @return 全ての顧客情報
     */
    List<Customer> getAllCustomers();

    List<Customer> getCustomersByFilter(Map<String, List<String>> filter);

    Customer getCustomerById(String id);

}
