package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class will validate all the methods implemented as part
 * Theater class
 */
public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(), 37.5);
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }

    @Test
    void TestReserve() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        assertTrue(theater.reserve(john, 2, 4) instanceof Reservation);
    }

    @Test
     void TestReserveException() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");

        Exception exception = assertThrows( RuntimeException.class,
                () -> theater.reserve(john, 0, 4));
        assertTrue(exception.getMessage().contains("not able"));
    }

    @Test
    void TestHandlePlural() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        assertEquals(theater.humanReadableFormat(Duration.ofMinutes(90)),"(1 hour 30 minutes)");
    }

    @Test
    void TestMain() {
        Theater.main(null);
    }
}
