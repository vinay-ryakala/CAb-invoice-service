package com.bribgelabz;

public class InvoiceSummary
{
   private int noOfRides;
   private double totalFare;
   private double avgFare;

   public InvoiceSummary(int noOfRides, double totalFare) {
      this.noOfRides = noOfRides;
      this.totalFare = totalFare;
      this.avgFare = this.totalFare/this.noOfRides;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      InvoiceSummary that = (InvoiceSummary) o;

      if (noOfRides != that.noOfRides) return false;
      if (Double.compare(that.totalFare, totalFare) != 0) return false;
      return Double.compare(that.avgFare, avgFare) == 0;
   }

}
