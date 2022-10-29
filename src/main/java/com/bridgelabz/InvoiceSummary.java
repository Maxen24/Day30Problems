package com.bridgelabz;
// UC-3 Enhanced Invoice
// The Invoice Generator should now return the following as part of the invoice -
// Total Number of Rides
// Total Fare
// Average Fare Per Ride
public class InvoiceSummary {
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare =this.totalFare/numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return numberOfRides == summary.numberOfRides && Double.compare(summary.totalFare, totalFare) == 0 && Double.compare(summary.averageFare, averageFare) == 0;
    }

}

