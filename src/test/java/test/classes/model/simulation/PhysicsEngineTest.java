package test.classes.model.simulation;

import mvc.model.simulation.engine.PhysicsEngine;
import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.engine.impl.*;
import mvc.model.simulation.observer.common.VehicleObserver;
import mvc.model.vehicle.common.Car;
import mvc.model.vehicle.vehicle.Vehicle;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhysicsEngineTest {

    private PhysicsEngine physicsEngine;
    private Vehicle car;

    @BeforeEach
    public void setUp() {
        car = new Car(10, 10, 10, VehicleObserver.getInstance());
    }

    @Test
    public void moveSimulationTest() {
        UniformModel model = new UniformModel(0, 70, 1000, 10, 15);

        physicsEngine = new PhysicsEngine(car);
        physicsEngine.setModel(model);
        physicsEngine.moveSimulation(new UniformWithNoStartingSpeedStrategy());

        double expected = 20.11;
        System.out.println("expected: " + expected + "\n"
                + "actual: " + physicsEngine.getModel().getTime());

        System.out.println(physicsEngine.getModel().getMaxSpeed() + " " +
                physicsEngine.getModel().getDistance() + " " +
                physicsEngine.getModel().getAcceleration() + " " +
                physicsEngine.getModel().getDelay() + " " +
                physicsEngine.getModel().getTime());

        Assert.assertEquals(expected, physicsEngine.getModel().getTime(), 0.1);
    }

    @Test
    public void moveWithoutBrakingSimulationTest() {
        UniformModel model = new UniformModel(0, 50, 500, 10, 15);

        physicsEngine = new PhysicsEngine(car);
        physicsEngine.setModel(model);
        physicsEngine.moveSimulation(new WithoutBreakingWithNoStartingSpeedStrategy());

        double expected = 12.5;
        System.out.println("expected: " + expected + "\n"
                + "actual: " + physicsEngine.getModel().getTime());

        System.out.println(physicsEngine.getModel().getMaxSpeed() + " " +
                physicsEngine.getModel().getDistance() + " " +
                physicsEngine.getModel().getAcceleration() + " " +
                physicsEngine.getModel().getDelay() + " " +
                physicsEngine.getModel().getTime());

        Assert.assertEquals(expected, physicsEngine.getModel().getTime(), 0);
    }

    @Test
    public void moveWithoutAcceleratingSimulationTest() {
        UniformModel model = new UniformModel(0, 50, 1000, 10, 5);

        physicsEngine = new PhysicsEngine(car);
        physicsEngine.setModel(model);
        physicsEngine.moveSimulation(new WithoutAccelerationStrategy());

        double expected = 25;
        System.out.println("expected: " + expected + "\n"
                + "actual: " + physicsEngine.getModel().getTime());

        System.out.println(physicsEngine.getModel().getMaxSpeed() + " " +
                physicsEngine.getModel().getDistance() + " " +
                physicsEngine.getModel().getAcceleration() + " " +
                physicsEngine.getModel().getDelay() + " " +
                physicsEngine.getModel().getTime());

        Assert.assertEquals(expected, physicsEngine.getModel().getTime(), 0);
    }

    @Test
    public void moveNormalWithStartingSpeedSimulationTest() {
        UniformModel model = new UniformModel(40, 50, 1000, 10, 5);

        physicsEngine = new PhysicsEngine(car);
        physicsEngine.setModel(model);
        physicsEngine.moveSimulation(new UniformWithStartingSpeedStrategy());

        double expected = 23.5;
        System.out.println("expected: " + expected + "\n"
                + "actual: " + physicsEngine.getModel().getTime());

        System.out.println(physicsEngine.getModel().getMaxSpeed() + " " +
                physicsEngine.getModel().getDistance() + " " +
                physicsEngine.getModel().getAcceleration() + " " +
                physicsEngine.getModel().getDelay() + " " +
                physicsEngine.getModel().getTime());

        Assert.assertEquals(expected, physicsEngine.getModel().getTime(), 0);
    }

    @Test
    public void moveWithoutBreakingWithStartingSpeedSimulationTest() {
        UniformModel model = new UniformModel(30, 50, 1000, 10, 5);

        physicsEngine = new PhysicsEngine(car);
        physicsEngine.setModel(model);
        physicsEngine.moveSimulation(new WithoutBreakingWithStartingSpeedStrategy());

        double expected = 19.5;
        System.out.println("expected: " + expected + "\n"
                + "actual: " + physicsEngine.getModel().getTime());

        System.out.println(physicsEngine.getModel().getMaxSpeed() + " " +
                physicsEngine.getModel().getDistance() + " " +
                physicsEngine.getModel().getAcceleration() + " " +
                physicsEngine.getModel().getDelay() + " " +
                physicsEngine.getModel().getTime());

        Assert.assertEquals(expected, physicsEngine.getModel().getTime(), 0);
    }

}
