package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int totalCapacity=10;
    private int surplusCapacity=10;

    private List<ParkingTicket> ticketList=new ArrayList<>();
    public ParkingLot(int totalCapacity, int surplusCapacity) {
        this.totalCapacity = totalCapacity;
        this.surplusCapacity = surplusCapacity;
    }

    public ParkingLot(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.surplusCapacity=totalCapacity;
    }

    public ParkingTicket park(Car car) {

        if(isSurplus()){
            int ticketID=generateTicketID();
            ParkingTicket ticket=new ParkingTicket(ticketID);
            ticketList.add(ticket);
            return ticket;
        }
        return null;
    }

    private int generateTicketID(){
        return (int)(Math.random());
    }

    private boolean isSurplus(){
        return surplusCapacity>0;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if(!ticketList.contains(parkingTicket)) return null;

        return new Car();
    }
}
