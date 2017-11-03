package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer;

import java.util.List;
import java.util.Map;

/**
 * 顧客情報の永続化層に対する操作を定義。
 */
public interface CustomerRepository {

    /**
     * 全ての顧客情報を返す。
     *
     * @return 全ての顧客情報
     */
    List<Customer> getAllCustomers();

    List<Customer> getCustomersByFilter(Map<String, List<String>> filter);

    Customer getCustomerById(String id);

}
