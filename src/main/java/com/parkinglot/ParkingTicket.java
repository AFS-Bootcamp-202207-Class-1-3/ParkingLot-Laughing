package com.parkinglot;

import java.util.Objects;

public class ParkingTicket {
    private int ticketID;
    private String carID;

    public ParkingTicket(int ticketID,String carID) {
        this.ticketID = ticketID;
        this.carID=carID;
    }


    public int getTicketID() {
        return ticketID;
    }

    public String getCarID() {
        return carID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingTicket)) return false;
        ParkingTicket ticket = (ParkingTicket) o;
        return ticketID == ticket.ticketID && carID.equals(ticket.carID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, carID);
    }
}
