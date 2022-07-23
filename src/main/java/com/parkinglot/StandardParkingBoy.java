package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy implements ParkingBoyInterface{
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        int parkingLotIndex;
        for(parkingLotIndex=0;parkingLotIndex<parkingLots.size();parkingLotIndex++){
            ParkingLot parkingLot=parkingLots.get(parkingLotIndex);
            if(parkingLot.isSurplus()){
                return parkingLot.park(car);
            }
        }

       throw new NoAvailablePositionException();
    }

    @Override
    public Car fetchCar(ParkingTicket parkingTicket) {
        return null;
    }
}
