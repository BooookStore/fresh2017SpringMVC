package com.packt.webstore.domain;

/**
 * 顧客を表現するドメイン
 */
public class Customer {

    public Customer() {
    }

    private String customerId;

    private String name;

    private String address;

    private int noOfOrdersMade;

    /**
     * 全ての顧客情報を初期化
     *
     * @param customerId
     * @param name
     * @param address
     * @param noOfOrdersMade
     */
    public Customer(String customerId, String name, String address, int noOfOrdersMade) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
