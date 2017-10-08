package mvc.model.vehicle.vehicle;

import mvc.model.road.Route;
import mvc.model.road.common.EndPoint;
import mvc.model.road.common.StartPoint;
import mvc.model.simulation.observer.Observable;
import mvc.model.simulation.observer.Observer;
import mvc.model.simulation.observer.common.VehicleObserver;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public abstract class Vehicle implements Observable {

    protected double acceleration;  //m/s^2
    protected double delay;
    protected double fuelUsage;     //l/100 000m
    protected double currentSpeed;
    protected VehicleObserver observer;

    private Route route;

    public Vehicle(double acceleration, double delay, double fuelUsage, VehicleObserver observer) {
        this.acceleration = acceleration;
        this.delay = delay;
        this.fuelUsage = fuelUsage;
        this.observer = observer;
        call();
    }

    public double timeToOvercomeUniformAcceleration(long distance, double startingSpeed, double maxSpeed) {
        //TODO maxSpeed
        if (startingSpeed == 0)
            return Math.sqrt((2 * distance) / acceleration);
        else {
            double b = 2 * startingSpeed;
            double c = 2 * distance;
            double delta = pow(b, 2) + (8 * acceleration * distance);
            if (delta > 0) {
                return ((-b) + sqrt(delta)) / (2 * acceleration);
            } else if (delta == 0) {
                return (-b) / (2 * acceleration);
            } else {
                return Double.NaN;
            }
        }
    }

    public double timeToOvercomeUniform(long distance, double speed) {
        return distance / speed;
    }

    public double fuelUsedToOvercome(long distance) {
        return (fuelUsage / 100000) * distance;
    }

    @Override
    public void addObserver(Observer o) {
        this.observer = (VehicleObserver) o;
    }

    @Override
    public void removeObserver(Observer o) {
        observer.removeObject(this);
        this.observer = null;
    }

    @Override
    public void call() {
        observer.addObject(this);
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(double fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public VehicleObserver getObserver() {
        return (VehicleObserver) observer;
    }

    public void setObserver(VehicleObserver observer) {
        this.observer = observer;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
