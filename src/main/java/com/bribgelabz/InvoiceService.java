package com.bribgelabz;

public class InvoiceService
{
   public static final double MIN_COST_PER_KM = 10.0;
   public static final int COST_PER_TIME = 1;
   public static final double MIN_FARE = 5.0;
   private  RideRepository rideRepository;

   public InvoiceService(){
      this.rideRepository = new RideRepository();
   }

   public double calculateFare(double distance, int time)
   {
      double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
      return Math.max(totalFare, MIN_FARE);
   }

   public InvoiceSummary calculateFare(Ride[] rides)
   {
      double totalFare = 0.0;
      for(Ride ride : rides) {
         totalFare += this.calculateFare(ride.distnce, ride.time);
      }
     return new InvoiceSummary(rides.length, totalFare);
   }

   public void addRides(String userId, Ride[] rides)
   {
      this.rideRepository.addRides(userId,rides);
   }

   public InvoiceSummary getInvoiceSummary(String userId)
   {
      return this.calculateFare(rideRepository.getRides(userId));
   }
}
