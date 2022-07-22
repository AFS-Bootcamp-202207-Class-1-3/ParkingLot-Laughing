package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_car(){
        Car car=new Car("A123");
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=parkingLot.park(car);

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_null_when_park_given_car_no_position(){
        Car car=new Car("A123");
        ParkingLot parkingLot=new ParkingLot(0);

        ParkingTicket parkingTicket=parkingLot.park(car);

        assertNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetchCar_given_true_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=parkingLot.park(new Car("A123"));

        assertNotNull(parkingLot.fetchCar(parkingTicket));
    }

    @Test
    public void should_return_null_when_fetchCar_given_used_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=parkingLot.park(new Car("A123"));;
        parkingLot.fetchCar(parkingTicket);
        //use ticket again
        Car car=parkingLot.fetchCar(parkingTicket);
        assertNull(car);
    }

    @Test
    public void should_return_null_when_fetchCar_given_wrong_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);

        ParkingTicket parkingTicket=new ParkingTicket(0);

        //not provide the ticket
        assertNull(parkingLot.fetchCar(parkingTicket));
        //no ticket
        assertNull(parkingLot.fetchCar(null));
    }

    @Test
    public void should_return_corresponding_car_when_fetchCar_given_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);

        Car car1=new Car("A123");
        Car car2=new Car("A321");
        ParkingTicket ticket1=parkingLot.park(car1);
        ParkingTicket ticket2=parkingLot.park(car2);

        assertEquals(car1,parkingLot.fetchCar(ticket1));
        assertEquals(car2,parkingLot.fetchCar(ticket2));
    }
}
