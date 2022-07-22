package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_car(){
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket=parkingBoy.park(new Car("A123"));

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetchCar_given_true_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket=parkingBoy.park(new Car("A123"));
        Car car=parkingBoy.fetchCar(parkingTicket);

        assertNotNull(car);
    }
}