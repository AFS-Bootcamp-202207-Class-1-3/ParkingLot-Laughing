package com.parkinglot;

import java.util.List;

public class MaxSurplusParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingLot getFitParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot parkingLot = parkingLots.stream().reduce(new ParkingLot(0), (preParkLot, nextParkLot) -> {
            return nextParkLot.getSurplusCapacity() > preParkLot.getSurplusCapacity() ? nextParkLot : preParkLot;
        });

        if(parkingLot.isSurplus()) return parkingLot;

        return null;
    }
}
