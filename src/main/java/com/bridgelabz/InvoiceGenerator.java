
package com.bridgelabz;
public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MIN_COST_PER_KILOMETER = 10;
    private static final double MIN_FARE = 5;

    // UC-1 Calculate fare
    // Given distance and time, the invoice generator should return
    // the total fare for the journey.
    // Cost-Rs 10km +Rs 1 per minute.
    // Minimum Fare - Rs 5
    public double calculateFare(double distance, int time){
        double totalFare= distance *MIN_COST_PER_KILOMETER+time*COST_PER_TIME;
        return Math.max(totalFare , MIN_FARE);

    }
    // UC-3 Enhanced Invoice
    // The Invoice Generator should now return the following as part of the invoice -
    // Total Number of Rides
    // Total Fare
    // Average Fare Per Ride
    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride:rides)
            totalFare += this.calculateFare(ride.distance, ride.time);
        return new InvoiceSummary(rides.length, totalFare);
    }
}