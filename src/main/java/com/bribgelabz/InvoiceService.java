package com.bribgelabz;

public class InvoiceService
{
   public static final double MIN_COST_PER_KM = 10.0;
   public static final int COST_PER_TIME = 1;
   public static final double MIN_FARE = 5.0;
   private  RideRepository rideRepository;
   private static final double MIN_COST_PER_KM_PREMIUM = 15.0;
   private static final int MIN_COST_PER_TIME_PREMIUM = 2;
   private static final double MINIMUM_FARE_PREMIUM = 20.0;

   public InvoiceService(){
      this.rideRepository = new RideRepository();
   }

   public double calculateFare(double distance, int time)
   {
      double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
      return Math.max(totalFare, MIN_FARE);
   }
   public double calculateFare(String type, double distance, int time)
   {
      double totalfare = 0;
      double fare = 0;
      if (type.toLowerCase().equals("normal")) {
         totalfare = (distance * MIN_COST_PER_KM) + (time * COST_PER_TIME);
         fare = Math.max(totalfare, MIN_FARE);
      } else if (type.toLowerCase().equals("premium")) {
         totalfare = (distance * MIN_COST_PER_KM_PREMIUM) + (time * MIN_COST_PER_TIME_PREMIUM);
         fare = Math.max(totalfare, MINIMUM_FARE_PREMIUM);
      }
      return fare;
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