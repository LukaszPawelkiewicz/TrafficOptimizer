package mvc.model.simulation.strategy.uniform.impl;

import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.uniform.UniformStrategy;

public class UniformlyDelayedStrategy implements UniformStrategy {

    @Override
    public UniformModel move(UniformModel model) {
        UniformModel result = new UniformModel(model);

        result.setTime(result.getMaxSpeed() / result.getDelay());
        result.setDistance((result.getMaxSpeed() * result.getTime()) - ((result.getDelay() * Math.pow(result.getTime(), 2)) / 2));

        return result;
    }

}
