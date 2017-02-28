package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void get_name_of_customer() {
        Customer customer = new Customer("Customer");

        assertEquals("Customer", customer.getName());
    }
}