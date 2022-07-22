package com.parkinglot;

import java.util.Objects;

public class ParkingTicket {
    private int ticketID;

    public ParkingTicket(int ticketID){
        this.ticketID=ticketID;
    }


    public int getTicketID() {
        return ticketID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingTicket)) return false;
        ParkingTicket that = (ParkingTicket) o;
        return ticketID == that.ticketID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID);
    }
}
