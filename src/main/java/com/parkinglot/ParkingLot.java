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
        if (!isSurplus()) {
            throw new NoAvailablePositionException();
        }

        int ticketID = generateTicketID(this.totalCapacity);
        ParkingTicket ticket = new ParkingTicket(ticketID, car.getCarID());
        ticketMap.put(ticket,car);

        this.surplusCapacity--;
        return ticket;
    }

    private boolean isTicketIDExist(int ticketID){
        for(ParkingTicket ticket: ticketMap.keySet()){
            if(ticketID==ticket.getTicketID()) return true;
        }
        return false;
    }
    private int generateTicketID(int range) {
        int result;
        Random rand = new Random();
        do {
            result=rand.nextInt(range);
        }while (isTicketIDExist(result));

        return result;
    }

    public boolean isSurplus() {
        return surplusCapacity > 0;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if (parkingTicket == null || !ticketMap.containsKey(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }

        this.surplusCapacity++;
        return this.ticketMap.remove(parkingTicket);
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getSurplusCapacity() {
        return surplusCapacity;
    }

    public double getSurplusCapacityRate(){
        if(totalCapacity==0) return 0.0;
        return (double)surplusCapacity/totalCapacity;
    }
}
