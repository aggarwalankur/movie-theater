package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This class will validate all the methods implemented as part
 * Customer class
 */
public class CustomerTests {

    @Test
    void VaildObjectsAreEqual() {
        Customer customer1 = new Customer("TestCase-01","id");
        Customer customer2 = new Customer("TestCase-01","id");
        assertTrue(customer1.equals(customer2));
    }

    @Test
    void VaildObjectsAreNotEqual() {
        Customer customer1 = new Customer("TestCase-01","id");
        Customer customer2 = new Customer("TestCase-02","id");
        assertFalse(customer1.equals(customer2));
    }

    @Test
    void VaildObjectsHaveSameHashCode() {
        Customer customer1 = new Customer("TestCase-01","id");
        Customer customer2 = new Customer("TestCase-01","id");
        assertTrue( customer1.hashCode()==customer2.hashCode() );
    }

    @Test
    void VaildObjectsDontHaveSameHashCode() {
        Customer customer1 = new Customer("TestCase-01","id");
        Customer customer2 = new Customer("TestCase-02","id");
        assertFalse( customer1.hashCode()==customer2.hashCode() );
    }

    @Test
    void TestValidToString() {
        Customer customer = new Customer("TestCase-01","id");
        assertEquals(customer.toString(),"name: TestCase-01");
    }

    @Test
    void TestInvalidToString() {
        Customer customer = new Customer("TestCase-01","id");
        assertNotEquals(customer.toString(),"name: TestCase-02");
    }
}
