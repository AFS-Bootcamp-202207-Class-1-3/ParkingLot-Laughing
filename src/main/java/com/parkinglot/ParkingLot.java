package com.parkinglot;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ParkingLot {

    private int totalCapacity = 10;
    private int surplusCapacity = 10;

    private Map<ParkingTicket,Car> ticketMap = new HashMap<>();

    public ParkingLot(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.surplusCapacity = totalCapacity;
    }

    public ParkingTicket park(Car car) {
        if (isSurplus()) {
            int ticketID = generateTicketID();
            ParkingTicket ticket = new ParkingTicket(ticketID);
            ticketMap.put(ticket,car);

            this.surplusCapacity--;
            return ticket;
        }
        return null;
    }

    private int generateTicketID() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    private boolean isSurplus() {
        return surplusCapacity > 0;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if (parkingTicket == null || !ticketMap.containsKey(parkingTicket)) return null;

        this.surplusCapacity++;
        return this.ticketMap.remove(parkingTicket);
    }
}
