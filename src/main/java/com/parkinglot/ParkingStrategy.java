package com.parkinglot;

import java.util.List;

public interface ParkingStrategy {
    ParkingLot getFitParkingLot(List<ParkingLot> parkingLots);
}
