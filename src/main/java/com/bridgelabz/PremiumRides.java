package com.bridgelabz;

// UC-5 Premium Rides (Bonus)
// The Cab Agency now supports 2 categories of rides:
// Normal Rides: Rs 10 per km, Rs 1 per minute, Minimum fare of Rs 5
// Premium Rides: Rs 15 per km, Rs 2 per minute, Minimum fare of Rs 20

public class PremiumRides {

    private static final double PREMIUM_COST_PER_KILOMETER = 15.0;
    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final int PREMIUM_MINIMUM_FARE = 20;

    /**
     * Calculating totalFare for premium customers.
     **/
    public double calculateFare(double distance, int time) {
        double totalFare = distance * PREMIUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
    }

    /**
     * Calculating total Fare for multiple premium rides.
     **/
    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0;

        for (Rides ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }

        return new InvoiceSummary(rides.length, totalFare);
    }
}

