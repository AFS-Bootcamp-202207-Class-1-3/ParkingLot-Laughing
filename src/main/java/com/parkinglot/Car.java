package com.parkinglot;

import java.util.Objects;

public class Car {
    private String carID;

    public Car(String carID) {
        this.carID = carID;
    }

    public String getCarID() {
        return carID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return carID.equals(car.carID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID);
    }
}
