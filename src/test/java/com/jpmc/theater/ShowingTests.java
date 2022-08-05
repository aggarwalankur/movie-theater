package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class will validate all the methods implemented as part
 * Showing class
 */
public class ShowingTests {

    @Test
    void TestGetMovie() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(),LocalTime.now()));
        assertEquals(showing.getMovie(),spiderMan);
    }

    @Test
    void TestGetStartTime() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)));
        assertEquals(showing.getStartTime(),LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)));
    }

    @Test
    void TestGetMovieFee() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)));
        assertEquals(showing.getMovieFee(),spiderMan.getTicketPrice());
    }

    @Test
    void TestGetSequenceOfTheDay() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)));
        assertEquals(showing.getSequenceOfTheDay(),4);
    }

    @Test
    void TestCalculateFee(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)));
        assertEquals(showing.calculateFee(3),37.5);
    }

    @Test
    void TestToString() {
        Movie spiderMan = new Movie("SpiderMan", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.now(),LocalTime.of(9,0)));
        String testString = "{\"sequenceOfTheDay\":\"4\",\"showStartTime\":\"2022-08-05T09:00\",\"movie\":\"SpiderMan\",\"ticketPrice\":\"$12.5\"}";
        assertEquals(showing.toString(), testString);
    }
}
