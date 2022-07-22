package com.parkinglot;

import java.util.Objects;

public class ParkingTicket {
    private int ticketID;
    private Car car;

    public ParkingTicket(int ticketID, Car car) {
        this.ticketID = ticketID;
        this.car = car;
    }


    public int getTicketID() {
        return ticketID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingTicket)) return false;
        ParkingTicket that = (ParkingTicket) o;
        return ticketID == that.ticketID && car == that.car;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID);
    }

    public Car getCar() {
        return car;
    }
}
