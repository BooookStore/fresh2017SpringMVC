DROP TABLE PRODUCTS IF EXISTS;
DROP TABLE CUSTOMERS IF EXISTS;

CREATE TABLE PRODUCTS (
  ID VARCHAR(25) PRIMARY KEY,
  NAME VARCHAR(50),
  DESCRIPTION  VARCHAR(250),
  UNIT_PRICE DECIMAL,
  MANUFACTURER VARCHAR(50),
  CATEGORY VARCHAR(50),
  CONDITION VARCHAR(50),
  UNITS_IN_STOCK BIGINT,
  UNITS_IN_ORDER BIGINT,
  DISCONTINUED BOOLEAN
);

CREATE TABLE CUSTOMERS (
  CUSTOMER_ID VARCHAR(50) PRIMARY KEY,
  NAME VARCHAR(50),
  ADDRESS VARCHAR(255),
  NO_OF_ORDERS_MADE BIGINT
);