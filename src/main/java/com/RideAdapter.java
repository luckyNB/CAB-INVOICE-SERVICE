package com;

public abstract class RideAdapter {
    private static final int NORMAL_COST_PER_TIME = 1;
    private static final double NORMAL_MINIMUM_COST_PER_KILOMETER = 10;
    private static final double NORMAL_MINIMUM_FARE = 5;

    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final double PREMIUM_MINIMUM_FARE = 20;
    private RideRepository rideRepository;
    RideCategory rideCategory;

    {
        rideCategory = RideCategory.NORMALRIDE;
    }

    public double calculateFare(double distance, int time) {
        double totalFare = 0;
        if (rideCategory.equals(RideCategory.NORMALRIDE)) {
            totalFare = distance * NORMAL_MINIMUM_COST_PER_KILOMETER + time * NORMAL_COST_PER_TIME;
            if (totalFare < NORMAL_MINIMUM_FARE)
                return NORMAL_MINIMUM_FARE;
            return totalFare;
        } else if (rideCategory.equals(RideCategory.PREMIUMRIDE)) {
            totalFare = distance * PREMIUM_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
            if (totalFare < PREMIUM_MINIMUM_FARE)
                return PREMIUM_MINIMUM_FARE;
            return totalFare;
        }
      return 0;
    }

    public RideAdapter() {
        this.rideRepository = new RideRepository();
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceServide(String userId, RideCategory rideCategory) {
        this.rideCategory = rideCategory;
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
