package com.parkinglot;

public class ParkingLot {

    private int totalCapacity=10;
    private int surplusCapacity=10;

    public ParkingLot(int totalCapacity, int surplusCapacity) {
        this.totalCapacity = totalCapacity;
        this.surplusCapacity = surplusCapacity;
    }

    public ParkingLot(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.surplusCapacity=totalCapacity;
    }

    public ParkingTicket park(Car car) {

        return isSurplus()?new ParkingTicket():null;
    }



    private boolean isSurplus(){
        return surplusCapacity>0;
    }
}
