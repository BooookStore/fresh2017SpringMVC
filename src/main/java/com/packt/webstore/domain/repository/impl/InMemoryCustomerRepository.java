package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 組み込みデータベースに対して、顧客情報をに関する操作方法を提供。
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("SELECT * FROM customers", new CustomerMapper());
    }

    @Override
    public List<Customer> getCustomersByFilter(Map<String, List<String>> filter) {
        String SQL = "SELECT * FROM customers WHERE customer_id IN (:name) AND name IN (:address)";
        return jdbcTemplate.query(SQL, filter, new CustomerMapper());
    }

    @Override
    public Customer getCustomerById(String id) {
        String SQL = "SELECT * FROM customers WHERE customer_id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(SQL, params, new CustomerMapper());
    }

    /**
     * データベース上の、１顧客レコードに対するマップ機能を提供
     */
    private static final class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Customer(
                    resultSet.getString("CUSTOMER_ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("ADDRESS"),
                    resultSet.getInt("NO_OF_ORDERS_MADE")
            );
        }
    }
}
