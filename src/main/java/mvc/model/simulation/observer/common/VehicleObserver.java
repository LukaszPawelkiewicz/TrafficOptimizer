package mvc.model.simulation.observer.common;

import mvc.model.simulation.observer.Observer;
import mvc.model.vehicle.vehicle.Vehicle;

import java.util.List;

public class VehicleObserver extends Observer<Vehicle> {

    private static Observer<Vehicle> ourInstance = new VehicleObserver();

    public static List<Vehicle> getVehicles() {
        return ourInstance.getObjects();
    }

    public static VehicleObserver getInstance() {
        return (VehicleObserver) ourInstance;
    }

    private VehicleObserver() {
    }
}
