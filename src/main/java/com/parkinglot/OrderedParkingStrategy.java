package com.parkinglot;

import java.util.List;

public class OrderedParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingLot getFitParkingLot(List<ParkingLot> parkingLots) {
        for(ParkingLot parkingLot: parkingLots){
            if(parkingLot.isSurplus()){
                return parkingLot;
            }
        }
        return null;
    }
}
