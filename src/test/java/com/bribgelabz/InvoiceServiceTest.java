package com.bribgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest
{
   InvoiceService invoiceService;

   @Before
   public void setUp() {
      invoiceService = new InvoiceService();
   }

   @Test
   public void givenDistanceTimeReturnFare() {
      double distance = 2.0;
      int time = 5;
      double fare = invoiceService.calculateFare(distance, time);
      Assert.assertEquals(25, fare, 0.0);
   }
   @Test
   public void givenLessDistanceTimeReturnMinFare() {
      double distance = 0.1;
      int time = 1;
      double fare = invoiceService.calculateFare(distance, time);
      Assert.assertEquals(5, fare, 0.0);
   }
   @Test
   public void givenMultipleRideReturnInvoiceSummary() {
      Ride[] rides = {new Ride(2.0, 5),
              new Ride(0.1, 1)
      };
      InvoiceSummary summary = invoiceService.calculateFare(rides);
      InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
      Assert.assertEquals(expectedSummary, summary);
   }
   @Test
   public void givenUserIdAndRides_ReturnInvoiceSummary(){
      String userId = "Vinay";
      Ride[] rides = {new Ride(2.0, 5),
              new Ride(0.1, 1)};
      invoiceService.addRides(userId, rides);
      InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
      InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
      Assert.assertEquals(expectedInvoiceSummary, summary);
   }
   @Test
   public void givenDistanceTimeandTypeofRide_ShouldReturnMinFare() {
      double distance = 0.1;
      int time = 1;
      String type = "Premium";
      double fare = invoiceService.calculateFare(type, distance, time);
      Assert.assertEquals(20,fare,0.0);
   }
}
