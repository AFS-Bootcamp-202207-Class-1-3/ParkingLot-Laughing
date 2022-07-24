package com.parkinglot;

import java.util.List;

public class MaxSurplusRateParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingLot getFitParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream().reduce(new ParkingLot(0), (preParkLot, nextParkLot) -> {
            return nextParkLot.getSurplusCapacityRate() > preParkLot.getSurplusCapacityRate() ? nextParkLot : preParkLot;
        });

        if(parkingLot.isSurplus()){
            return parkingLot;
        }

        return null;
    }
}
