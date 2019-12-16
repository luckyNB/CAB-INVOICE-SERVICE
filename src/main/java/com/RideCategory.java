package com;

public enum RideCategory {

    NORMALRIDE {
        private static final int COST_PER_TIME = 1;
        private static final double MINIMUM_COST_PER_KILOMETER = 10;
        private static final double MINIMUM_FARE = 5;

 },
    PREMIUMRIDE {
        private static final int COST_PER_TIME = 2;
        private static final double MINIMUM_COST_PER_KILOMETER = 15;
        private static final double MINIMUM_FARE = 20;


    }
}