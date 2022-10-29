package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class InvoiceGeneratorTest {

    // UC-1 Calculate fare
    // Given distance and time, the invoice generator should return
    // the total fare for the journey.
    // Cost-Rs 10km +Rs 1 per minute.
    // Minimum Fare - Rs 5

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    // UC-3 Enhanced Invoice
    // The Invoice Generator should now return the following as part of the invoice -
    // Total Number of Rides
    // Total Fare
    // Average Fare Per Ride

    @Test
    public void givenDistanceAndTime_shouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Rides[] rides = {new Rides(2.0, 5), new Rides(0.1, 1)};
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    //UC-4 Given a user id, the Invoice Service gets the list
    // of rides from the RideRepository, and returns the invoice.
    @Test
    public void givenDistanceAndTime_shouldReturnInvoice() {
        HashMap<Integer, Rides[]> rideRepo = new HashMap<>();
        Rides[] rides1 = {new Rides(2.0, 5), new Rides(0.1, 1)};
        Rides[] rides2 = {new Rides(10.0, 2), new Rides(5.0, 1)};
        Rides[] rides3 = {new Rides(7.0, 3), new Rides(5.0, 1)};
        Rides[] rides4 = {new Rides(4.0, 3), new Rides(5.0, 4)};
        rideRepo.put(1, rides1);
        rideRepo.put(2, rides2);
        rideRepo.put(3, rides3);
        rideRepo.put(4, rides4);
        int userID = 1;
        RideRepository rideRepository = new RideRepository(rideRepo, userID);
        InvoiceSummary invoiceSummary = rideRepository.calculateFare();
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }
        // UC-5 Premium Rides (Bonus)
        // The Cab Agency now supports 2 categories of rides:
        // Normal Rides: Rs 10 per km, Rs 1 per minute, Minimum fare of Rs 5
        // Premium Rides: Rs 15 per km, Rs 2 per minute, Minimum fare of Rs 20
    @Test
    public void givenMultipleRides_whenGivenWithCategories_shouldReturnInvoiceAccordingToType() {

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Rides[] rides = {new Rides(2.0, 5), new Rides(5.0, 8)};


        String category = "Premium";

        if (category == "Premium") {
            PremiumRides premiumInvoice = new PremiumRides();

            InvoiceSummary premiumInvoiceSummary = premiumInvoice.calculateFare(rides);
            InvoiceSummary expectedPremiumInvoiceSummary = new InvoiceSummary(2, 131.0);
            Assert.assertEquals(expectedPremiumInvoiceSummary, premiumInvoiceSummary);
        } else {
            InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
            InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
            Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
        }
    }
}


