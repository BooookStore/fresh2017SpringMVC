package com.packt.webstore.service;

import com.packt.webstore.domain.Customer;

import java.util.List;

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

}
