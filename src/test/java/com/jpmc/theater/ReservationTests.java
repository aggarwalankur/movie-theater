package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class covers below test cases
 * 1) Special movie total fees on discount days (1,2,7)
 * 2) Special movie total fees on discount days (1,2,7) between 11am & 4pm
 * 3) Regular movie total fees on discount days (1,2,7) between 11am & 4pm
 * 4) Special movie total fees on regular days between 11am & 4pm
 * 5) Regular movie total fees on regular days between 11am & 4pm
 * 6) Regular movie total fees on discount days (1,2,7)
 */
public class ReservationTests {

    @Test
    void TestSpecialMovieTotalFeeOnDiscountDays() {
        Showing showing;
        Reservation reservation;
        Customer customer = new Customer("John Doe", "unused-id");
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        //On 1st Day
        showing = new Showing(spiderMan,1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.5);
        //On 2nd Day
        showing = new Showing(spiderMan,2, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 30.0);
        //On 7th Day
        showing = new Showing(spiderMan,7, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 30.0);
    }

    @Test
    void TestAnyMovieTotalFeeOnDiscountDaysBetween11And4() {
        Showing showing;
        Reservation reservation;
        Customer customer = new Customer("John Doe", "unused-id");
        Movie specialMovie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie nonSpecialMovie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        //On 1st Day
        showing = new Showing(specialMovie,1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
        showing = new Showing(nonSpecialMovie,1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
        //On 2nd Day
        showing = new Showing(specialMovie,2, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
        showing = new Showing(nonSpecialMovie,1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
        //On 7th Day
        showing = new Showing(specialMovie,7, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
        showing = new Showing(nonSpecialMovie,1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
    }

    @Test
    void TestAnyMovieTotalFeeOnNonDiscountDaysBetween11And4() {
        Showing showing;
        Reservation reservation;
        Customer customer = new Customer("John Doe", "unused-id");
        Movie specialMovie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie nonSpecialMovie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);

        showing = new Showing(specialMovie,6, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);

        showing = new Showing(nonSpecialMovie,6, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.125);
    }

    @Test
    void TestRegularMovieTotalFeeOnDiscountDays() {
        Showing showing;
        Reservation reservation;
        Customer customer = new Customer("John Doe", "unused-id");
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        //On 1st Day
        showing = new Showing(spiderMan,1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 28.5);
        //On 2nd Day
        showing = new Showing(spiderMan,2, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 31.5);
        //On 7th Day
        showing = new Showing(spiderMan,7, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        reservation = new Reservation(customer, showing, 3);
        assertTrue(reservation.totalFee() == 34.5);
    }

}
