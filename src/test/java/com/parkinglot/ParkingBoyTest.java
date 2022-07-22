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

    @Test
    public void should_return_error_message_when_fetchCar_given_wrong_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket=new ParkingTicket(0,"A111");

        //not provide the ticket
        Exception exception1=assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.fetchCar(parkingTicket));
        assertEquals(exception1.getMessage(),"Unrecognized parking ticket");
        //no ticket
        Exception exception2=assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.fetchCar(null));
        assertEquals(exception2.getMessage(),"Unrecognized parking ticket");
    }

    @Test
    public void should_return_error_message_when_fetchCar_given_used_ticket(){
        ParkingLot parkingLot=new ParkingLot(10);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket=parkingBoy.park(new Car("A123"));;
        parkingBoy.fetchCar(parkingTicket);
        //use ticket again
        Exception exception=assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.fetchCar(parkingTicket));
        assertEquals(exception.getMessage(),"Unrecognized parking ticket");
    }
}