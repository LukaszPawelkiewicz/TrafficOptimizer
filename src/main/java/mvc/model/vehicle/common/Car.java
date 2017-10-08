package mvc.model.vehicle.common;

import mvc.model.simulation.observer.common.VehicleObserver;
import mvc.model.vehicle.vehicle.Vehicle;

public class Car extends Vehicle {

    public Car(double acceleration, double delay, double fuelUsage, VehicleObserver observer) {
        super(acceleration, delay, fuelUsage, observer);
    }

}
