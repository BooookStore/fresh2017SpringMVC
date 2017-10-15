package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer;

import java.util.List;

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

}
