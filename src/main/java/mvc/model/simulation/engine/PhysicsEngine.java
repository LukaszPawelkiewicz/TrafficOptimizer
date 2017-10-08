package mvc.model.simulation.engine;

import mvc.model.road.common.Crossing;
import mvc.model.road.common.EndPoint;
import mvc.model.road.common.Road;
import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.engine.EngineStrategy;
import mvc.model.simulation.strategy.engine.impl.UniformWithNoStartingSpeedStrategy;
import mvc.model.simulation.strategy.engine.impl.UniformWithStartingSpeedStrategy;
import mvc.model.simulation.strategy.engine.impl.WithoutBreakingWithNoStartingSpeedStrategy;
import mvc.model.simulation.strategy.engine.impl.WithoutBreakingWithStartingSpeedStrategy;
import mvc.model.vehicle.vehicle.Vehicle;

public class PhysicsEngine {

    private UniformModel model;
    private Vehicle vehicle;
    private EngineStrategy strategy;

    public PhysicsEngine(Vehicle vehicle) {
        super();
        this.vehicle = vehicle;
    }

    public void moveSimulation() {
        if (model.getNext() == Road.class) {
            if (vehicle.getCurrentSpeed() > 0) {
                strategy = new WithoutBreakingWithStartingSpeedStrategy();
            } else {
                strategy = new WithoutBreakingWithNoStartingSpeedStrategy();
            }
        } else if (model.getNext() == Crossing.class) {
            if (vehicle.getCurrentSpeed() > 0) {
                strategy = new UniformWithStartingSpeedStrategy();
            } else {
                strategy = new UniformWithNoStartingSpeedStrategy();
            }
        } else if (model.getNext() == EndPoint.class) {
            if (vehicle.getCurrentSpeed() > 0) {
                strategy = new UniformWithStartingSpeedStrategy();
            } else {
                strategy = new UniformWithNoStartingSpeedStrategy();
            }
        }

        if (strategy != null) {
            model = strategy.moveSimulation(model, vehicle);
        }
    }

    public void moveSimulation(EngineStrategy strategy) {
        model = strategy.moveSimulation(model, vehicle);
    }

    public UniformModel getModel() {
        return model;
    }

    public void setModel(UniformModel model) {
        this.model = model;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
