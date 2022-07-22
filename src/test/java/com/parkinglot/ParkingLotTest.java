package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_car(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=parkingLot.park(car);

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_null_when_park_given_car_no_position(){
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(10,0);

        ParkingTicket parkingTicket=parkingLot.park(car);

        assertNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetchCar_given_true_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=parkingLot.park(new Car());

        assertNotNull(parkingLot.fetchCar(parkingTicket));
    }

    @Test
    public void should_return_null_when_fetchCar_given_used_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=new ParkingTicket(0);

        assertNull(parkingLot.fetchCar(parkingTicket));
    }
}
