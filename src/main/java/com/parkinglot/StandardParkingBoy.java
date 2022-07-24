package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParkingBoy{
    private List<ParkingLot> parkingLots;
    private Map<ParkingTicket,ParkingLot> mapParkingTicketAndLot=new HashMap<>();

    private ParkingStrategy parkingStrategy=new OrderedParkingStrategy();
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
       ParkingLot parkingLot=parkingStrategy.getFitParkingLot(this.parkingLots);
       if(parkingLot==null) throw new NoAvailablePositionException();

        ParkingTicket parkingTicket=parkingLot.park(car);
        mapParkingTicketAndLot.put(parkingTicket,parkingLot);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if(!mapParkingTicketAndLot.containsKey(parkingTicket)) throw new UnrecognizedParkingTicketException();
        ParkingLot parkingLot=mapParkingTicketAndLot.get(parkingTicket);
        mapParkingTicketAndLot.remove(parkingTicket);
        return parkingLot.fetchCar(parkingTicket);
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }
}
