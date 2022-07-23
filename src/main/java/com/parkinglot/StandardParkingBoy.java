package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy implements ParkingBoyInterface{
    private List<ParkingLot> parkingLots=new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }

    @Override
    public Car fetchCar(ParkingTicket parkingTicket) {
        return null;
    }
}
