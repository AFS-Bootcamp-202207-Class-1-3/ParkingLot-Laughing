package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyWithParkingLotsTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_car() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        ParkingTicket parkingTicket = parkingBoy.park(new Car("A123"));
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parking_ticket_when_park_given_a_car_and_first_is_full() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);

        ParkingTicket parkingTicket = parkingBoy.park(new Car("A123"));

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_corresponding_car_when_fetchCar_given_tickets() {
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(1), new ParkingLot(1));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        Car car1 = new Car("A123");
        Car car2 = new Car("A321");
        ParkingTicket ticket1 = parkingBoy.park(car1);
        ParkingTicket ticket2 = parkingBoy.park(car2);

        assertEquals(car1, parkingBoy.fetchCar(ticket1));
        assertEquals(car2, parkingBoy.fetchCar(ticket2));
    }


    @Test
    public void should_return_error_message_when_fetchCar_given_wrong_ticket(){
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
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
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        ParkingTicket parkingTicket=parkingBoy.park(new Car("A123"));;
        parkingBoy.fetchCar(parkingTicket);
        //use ticket again
        Exception exception=assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.fetchCar(parkingTicket));
        assertEquals(exception.getMessage(),"Unrecognized parking ticket");
    }


    @Test
    public void should_return_no_available_position_when_park_given_car_no_position(){
        Car car=new Car("A123");
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), new ParkingLot(0));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        Exception exception=assertThrows(NoAvailablePositionException.class,()-> parkingBoy.park(car));
        assertEquals(exception.getMessage(),"No available position");
    }

}