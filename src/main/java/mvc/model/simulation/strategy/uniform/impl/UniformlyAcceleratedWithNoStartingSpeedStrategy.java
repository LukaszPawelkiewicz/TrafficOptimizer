package mvc.model.simulation.strategy.uniform.impl;

import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.uniform.UniformStrategy;

public class UniformlyAcceleratedWithNoStartingSpeedStrategy implements UniformStrategy {

    @Override
    public UniformModel move(UniformModel model) {
        UniformModel result = new UniformModel(model);

        result.setTime(result.getMaxSpeed() / result.getAcceleration());
        result.setDistance((result.getAcceleration() * Math.pow(result.getTime(), 2)) / 2);

        return result;
    }
}
