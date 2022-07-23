package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_car(){
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10),new ParkingLot(10));
        ParkingBoyInterface parkingBoy=new StandardParkingBoy(parkingLots);

        ParkingTicket parkingTicket=parkingBoy.park(new Car("A123"));

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parking_ticket_when_park_given_a_car_and_first_is_full(){
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0),new ParkingLot(10));
        ParkingBoyInterface parkingBoy=new StandardParkingBoy(parkingLots);

        ParkingTicket parkingTicket=parkingBoy.park(new Car("A123"));

        assertNotNull(parkingTicket);
    }

}