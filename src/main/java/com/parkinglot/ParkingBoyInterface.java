package com.parkinglot;

public interface ParkingBoyInterface {
     ParkingTicket park(Car car);

     Car fetchCar(ParkingTicket parkingTicket);
}
