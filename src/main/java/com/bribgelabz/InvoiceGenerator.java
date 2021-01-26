package com.bribgelabz;

public class InvoiceGenerator
{
   public static final double MIN_COST_PER_KM = 10.0;
   public static final int COST_PER_TIME = 1;

   public double calculateFare(double distance, int time)
   {
      return distance * MIN_COST_PER_KM + time * COST_PER_TIME;
   }
}
