package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_car() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        ParkingBoyInterface parkingBoy = new StandardParkingBoy(parkingLots);

        ParkingTicket parkingTicket = parkingBoy.park(new Car("A123"));

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parking_ticket_when_park_given_a_car_and_first_is_full() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), new ParkingLot(10));
        ParkingBoyInterface parkingBoy = new StandardParkingBoy(parkingLots);

        ParkingTicket parkingTicket = parkingBoy.park(new Car("A123"));

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_corresponding_car_when_fetchCar_given_tickets() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
        ParkingBoyInterface parkingBoy = new StandardParkingBoy(parkingLots);
        Car car1 = new Car("A123");
        Car car2 = new Car("A321");
        ParkingTicket ticket1 = parkingBoy.park(car1);
        ParkingTicket ticket2 = parkingBoy.park(car2);

        assertEquals(car1, parkingBoy.fetchCar(ticket1));
        assertEquals(car2, parkingBoy.fetchCar(ticket2));
    }

}