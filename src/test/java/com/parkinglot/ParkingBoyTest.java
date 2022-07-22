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

    @Test
    public void should_return_corresponding_car_when_fetchCar_given_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car("A123");
        Car car2=new Car("A321");
        ParkingTicket ticket1=parkingBoy.park(car1);
        ParkingTicket ticket2=parkingBoy.park(car2);

        assertEquals(car1,parkingBoy.fetchCar(ticket1));
        assertEquals(car2,parkingBoy.fetchCar(ticket2));
    }
}