package test.classes.model.vehicle.common;


import mvc.model.simulation.observer.common.VehicleObserver;
import mvc.model.vehicle.common.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car(10, 10, 5.0, VehicleObserver.getInstance());
    }

    @Test
    public void timeToOvercomeUniformTest() {
        System.out.println("timeToOvercomeUniformTest start");
        double expected = 20;
        double actual = car.timeToOvercomeUniform(100, 5.0);
        System.out.print("expected: " + expected + "\n"
                + "actual: " + actual);
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void timeToOvercomeUniformAccelerationTest() {
        System.out.println("timeToOvercomeUniformAccelerationTest start");
        double expected = 10;
        double actual = car.timeToOvercomeUniformAcceleration(800, 30.0, 50);
        System.out.print("expected: " + expected + "\n"
                + "actual: " + actual);
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void fuelUsedToOvercomeTest() {
        System.out.println("timeToOvercomeUniformAccelerationTest start");
        double expected = 0.25;
        double actual = car.fuelUsedToOvercome(5000);
        System.out.print("expected: " + expected + "\n"
                + "actual: " + actual);
        Assert.assertEquals(expected, actual, 0.0);
    }
}
