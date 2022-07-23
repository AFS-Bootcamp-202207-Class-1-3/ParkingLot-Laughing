package com.parkinglot;

public class ParkingBoy implements ParkingBoyInterface{

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        return parkingLot.park(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return parkingLot.fetchCar(parkingTicket);
    }


}
