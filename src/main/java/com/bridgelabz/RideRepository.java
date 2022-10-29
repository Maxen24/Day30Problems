package com.bridgelabz;

import java.util.HashMap;

public class RideRepository {

    //UC-4 Given a user id, the Invoice Service gets the list
    // of rides from the RideRepository, and returns the invoice.

    public static HashMap<Integer, Rides[]> RIDE_REPOSITORY = null;
    public static Integer USER_ID =0;

    public RideRepository(HashMap<Integer, Rides[]> RIDE_REPOSITORY, Integer USER_ID){
        this.RIDE_REPOSITORY = RIDE_REPOSITORY;
        this.USER_ID = USER_ID;

    }
    public InvoiceSummary calculateFare(){
        if(this.USER_ID == null || this.RIDE_REPOSITORY.get(USER_ID) == null){
            throw  new NullPointerException("Null value is not allowed");
        }
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Rides[] userRideDetails = this.RIDE_REPOSITORY.get(USER_ID);
        double totalFare = 0;
        for (Rides ride : userRideDetails){
            totalFare += invoiceGenerator.calculateFare(ride.distance,ride.time);
        }
        return  new InvoiceSummary(userRideDetails.length, totalFare);
    }
}
