package mvc.model.simulation.strategy.uniform.impl;

import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.uniform.UniformStrategy;

public class UniformMoveStrategy implements UniformStrategy {

    @Override
    public UniformModel move(UniformModel model) {
        UniformModel result = new UniformModel(model);

        result.setTime(result.getDistance() / result.getMaxSpeed());

        return result;
    }
}
