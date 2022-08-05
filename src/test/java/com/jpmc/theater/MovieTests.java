package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1) Special movie with 25% Discount (specialMovieWith25PercentDiscount)
 * 2) Special movie on 1st day between 11-4 (SpecialMovieOn1st2nd7thDayBetween11And4)
 * 3) Special movie on 2nd day between 11-4 (SpecialMovieOn1st2nd7thDayBetween11And4)
 * 4) Special movie on 7th day between 11-4 (SpecialMovieOn1st2nd7thDayBetween11And4)
 * 5) Special movie on 1st day (SpecialMovieOn1st2nd7thDay)
 * 6) Special movie on 2nd day (SpecialMovieOn1st2nd7thDay)
 * 7) Special movie on 7th day (SpecialMovieOn1st2nd7thDay)
 * 8) Any movie between 11-4 on 1st, 2nd and 7th day (MovieWith25PercentDiscountOn1st2nd7thDay)
 * 9) Any movie with 20 percent discount (specialMovieWith20PercentDiscount)
 * 10) Any movie with 3 dollar discount (MovieWithThreeTwoOneDollarDiscount)
 * 11) Any movie with 1 dollar discount (MovieWithThreeTwoOneDollarDiscount)
 * 12) Any movie with 2 dollar discount (MovieWithThreeTwoOneDollarDiscount)
 * 13)Any movie with 25% discount (MovieWith25PercentDiscount)
 * 14) Special movie with 20% discount (specialMovieWith20PercentDiscount)
 * 15) Movie with no discount (MovieWithNoDiscount)
 * 16) Validate Equals Method
 * 17) Validate HashCode Method
 */
public class MovieTests {
    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0)));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void MovieWithThreeTwoOneDollarDiscount() {
        Showing showing;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        //Three Dollar discount
        showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0)));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
        //Two Dollar discount
        showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0)));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
        //One Dollar discount
        showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0)));
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void MovieWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void MovieWithNoDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        assertEquals(12.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }


    @Test
    void MovieWith25PercentDiscountOn1st2nd7thDay() {
        Showing showing;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        //First day
        showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
        //Second Day
        showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
        //Seventh Day
        showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void SpecialMovieOn1st2nd7thDay() {
        Showing showing;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),20, 1);
        Movie batMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),5, 1);
        //First day
        showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        assertEquals(16, spiderMan.calculateTicketPrice(showing));
        showing = new Showing(batMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        assertEquals(2, batMan.calculateTicketPrice(showing));
        //Second Day
        showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        assertEquals(16, spiderMan.calculateTicketPrice(showing));
        //Seventh Day
        showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        assertEquals(16, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void SpecialMovieOn1st2nd7thDayBetween11And4() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),14, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        //First day
        showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
        //Second Day
        showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 0)));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
        //Seventh Day
        showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0)));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void VaildObjectsAreEqual() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        Movie spiderManReload = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        assertTrue(spiderMan.equals(spiderManReload));
    }

    @Test
    void VaildObjectsAreNotEqual() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        Movie spiderManReload = new Movie("Spider-Man part 2", Duration.ofMinutes(90),14, 1);
        assertFalse(spiderMan.equals(spiderManReload));
        assertFalse(spiderMan.equals(null));
    }

    @Test
    void VaildObjectsHaveSameHashCode() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        Movie spiderManReload = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        assertTrue( spiderMan.hashCode()==spiderManReload.hashCode() );
    }

    @Test
    void VaildObjectsDontHaveSameHashCode() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        Movie spiderManReload = new Movie("Spider-Man part2", Duration.ofMinutes(90),14, 1);
        assertFalse( spiderMan.hashCode()==spiderManReload.hashCode() );
    }

    @Test
    void TestGetTitle() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        assertTrue(spiderMan.getTitle().equals("Spider-Man"));
    }

    @Test
    void TestGetRunningTime() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        assertTrue(spiderMan.getRunningTime().equals(Duration.ofMinutes(90)));
    }

    @Test
    void TestGetTicketPrice() {
        Movie spiderMan = new Movie("Spider-Man", Duration.ofMinutes(90),14, 1);
        assertTrue(spiderMan.getTicketPrice()==14);
    }

}
