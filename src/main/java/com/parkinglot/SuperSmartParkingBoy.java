package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperSmartParkingBoy implements ParkingBoyInterface{
    private List<ParkingLot> parkingLots;
    private Map<ParkingTicket, ParkingLot> mapParkingTicketAndLot = new HashMap<>();

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().reduce(new ParkingLot(0), (preParkLot, nextParkLot) -> {
            return nextParkLot.getSurplusCapacityRate() > preParkLot.getSurplusCapacityRate() ? nextParkLot : preParkLot;
        });

        if(parkingLot.isSurplus()){
            ParkingTicket parkingTicket=parkingLot.park(car);
            mapParkingTicketAndLot.put(parkingTicket,parkingLot);
            return parkingTicket;
        }

        throw new NoAvailablePositionException();
    }

    @Override
    public Car fetchCar(ParkingTicket parkingTicket) {
        if(!mapParkingTicketAndLot.containsKey(parkingTicket)) throw new UnrecognizedParkingTicketException();
        ParkingLot parkingLot=mapParkingTicketAndLot.get(parkingTicket);
        mapParkingTicketAndLot.remove(parkingTicket);
        return parkingLot.fetchCar(parkingTicket);
    }

}
