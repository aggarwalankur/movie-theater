package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;

    @Override
    public String toString() {
        return "{" +
                "\"sequenceOfTheDay\":\"" + sequenceOfTheDay +"\""+
                ",\"showStartTime\":\"" + showStartTime +"\""+
                ",\"movie\":\"" +movie.getTitle() +"\"" +
                ",\"ticketPrice\":\"$" + movie.getTicketPrice() +"\""+
                '}';
    }

    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }


    public double getMovieFee() {return movie.getTicketPrice();}

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public double calculateFee(int audienceCount) {
        return movie.calculateTicketPrice(this) * audienceCount;
    }
}
