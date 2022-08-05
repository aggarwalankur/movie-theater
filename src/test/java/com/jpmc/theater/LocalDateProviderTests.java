package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class will cover below test cases
 * 1) Make sure it's returning current date
 * 2) Make sure it's creating singleton object
 */
public class LocalDateProviderTests {

    @Test
    void TestCurrentDate() {
        assertTrue(LocalDateProvider.singleton().currentDate().equals(LocalDate.now()));
    }

    @Test
    void TestSingleton() {
        LocalDateProvider provider1 = LocalDateProvider.singleton();
        LocalDateProvider provider2 = LocalDateProvider.singleton();
        assertEquals(provider1, provider2);
    }
}
