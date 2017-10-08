package mvc.model.simulation.strategy.engine;

import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.vehicle.vehicle.Vehicle;

public interface EngineStrategy {
    UniformModel moveSimulation(UniformModel model, Vehicle vehicle);
}
