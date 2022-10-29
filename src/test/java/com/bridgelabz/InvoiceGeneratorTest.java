package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

    // UC-1 Calculate fare
    // Given distance and time, the invoice generator should return
    // the total fare for the journey.
    // Cost-Rs 10km +Rs 1 per minute.
    // Minimum Fare - Rs 5

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare = invoiceGenerator.calculateFare(distance, time );
        Assert.assertEquals(25,fare,0.0);
    }
    @Test
    public void givenDistanceAndTime_shouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare = invoiceGenerator.calculateFare(distance, time );
        Assert.assertEquals(5,fare,0.0);
    }

    // UC-3 Enhanced Invoice
    // The Invoice Generator should now return the following as part of the invoice -
    // Total Number of Rides
    // Total Fare
    // Average Fare Per Ride

    @Test
    public void givenDistanceAndTime_shouldReturnInvoiceSummary(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Rides[] rides = { new Rides(2.0, 5), new Rides(0.1, 1) };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedSummary,invoiceSummary);
    }
}

