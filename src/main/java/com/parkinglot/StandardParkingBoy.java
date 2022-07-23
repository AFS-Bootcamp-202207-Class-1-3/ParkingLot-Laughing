package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParkingBoy implements ParkingBoyInterface{
    private List<ParkingLot> parkingLots;
    private Map<ParkingTicket,Integer> mapParkingTicketAndLot=new HashMap<>();
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        int parkingLotIndex;
        for(parkingLotIndex=0;parkingLotIndex<parkingLots.size();parkingLotIndex++){
            ParkingLot parkingLot=parkingLots.get(parkingLotIndex);
            if(parkingLot.isSurplus()){
                ParkingTicket parkingTicket=parkingLot.park(car);
                mapParkingTicketAndLot.put(parkingTicket,parkingLotIndex);
                return parkingTicket;
            }
        }

       throw new NoAvailablePositionException();
    }

    @Override
    public Car fetchCar(ParkingTicket parkingTicket) {
        int parkingLotIndex=mapParkingTicketAndLot.get(parkingTicket);
        return parkingLots.get(parkingLotIndex).fetchCar(parkingTicket);
    }
}
