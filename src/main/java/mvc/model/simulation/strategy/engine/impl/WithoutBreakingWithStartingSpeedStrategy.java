package mvc.model.simulation.strategy.engine.impl;

import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.engine.EngineStrategy;
import mvc.model.simulation.strategy.uniform.UniformStrategy;
import mvc.model.simulation.strategy.uniform.impl.UniformMoveStrategy;
import mvc.model.simulation.strategy.uniform.impl.UniformlyAcceleratedWithStartingSpeedStrategy;
import mvc.model.vehicle.vehicle.Vehicle;

public class WithoutBreakingWithStartingSpeedStrategy implements EngineStrategy {

    @Override
    public UniformModel moveSimulation(UniformModel model, Vehicle vehicle) {
        model.setStartingSpeed(vehicle.getCurrentSpeed());
        UniformStrategy uniformStrategy = new UniformlyAcceleratedWithStartingSpeedStrategy();
        UniformModel phase1 = uniformStrategy.move(model);

        UniformModel tmp = new UniformModel(model);
        tmp.setDistance(tmp.getDistance() - phase1.getDistance());
        uniformStrategy = new UniformMoveStrategy();
        UniformModel phase3 = uniformStrategy.move(tmp);

        UniformModel result = new UniformModel(model);
        result.setTime(phase1.getTime() + phase3.getTime());

        vehicle.setCurrentSpeed(result.getMaxSpeed());
        return result;
    }
}
