package test.classes.model.simulation;

import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.strategy.uniform.UniformStrategy;
import mvc.model.simulation.strategy.uniform.impl.UniformlyAcceleratedWithNoStartingSpeedStrategy;
import mvc.model.simulation.strategy.uniform.impl.UniformlyDelayedStrategy;
import mvc.model.simulation.strategy.uniform.impl.UniformMoveStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniformMoveStrategyTest {

    private UniformModel model;
    private UniformStrategy uniformUniformStrategy;

    @BeforeEach
    public void setUp() {
        model = new UniformModel();
    }

    @Test
    public void uniformlyAcceleratedTest() {
        uniformUniformStrategy = new UniformlyAcceleratedWithNoStartingSpeedStrategy();
        model.setMaxSpeed(50);
        model.setAcceleration(5);
        UniformModel result = uniformUniformStrategy.move(model);

        double expectedTime = 10;
        double expectedDistance = 250;

        System.out.println("expected time: " + expectedTime + "\n"
                + "actual: " + result.getTime());
        System.out.println("expected distance: " + expectedDistance + "\n"
                + "actual: " + result.getDistance());

        Assert.assertEquals(result.getTime(), expectedTime, 0);
        Assert.assertEquals(result.getDistance(), expectedDistance, 0);
    }

    @Test
    public void uniformlyDelayedTest() {
        uniformUniformStrategy = new UniformlyDelayedStrategy();
        model.setMaxSpeed(50);
        model.setAcceleration(10);
        UniformModel result = uniformUniformStrategy.move(model);

        double expectedTime = 5;
        double expectedDistance = 125;

        System.out.println("expected time: " + expectedTime + "\n"
                + "actual: " + result.getTime());
        System.out.println("expected distance: " + expectedDistance + "\n"
                + "actual: " + result.getDistance());

        Assert.assertEquals(result.getTime(), expectedTime, 0);
        Assert.assertEquals(result.getDistance(), expectedDistance, 0);
    }

    @Test
    public void uniformTest() {
        uniformUniformStrategy = new UniformMoveStrategy();
        model.setDistance(500);
        model.setMaxSpeed(50);
        UniformModel result = uniformUniformStrategy.move(model);

        double expectedTime = 10;

        System.out.println("expected time: " + expectedTime + "\n"
                + "actual: " + result.getTime());

        Assert.assertEquals(result.getTime(), expectedTime, 0);
    }

    @Test
    public void fullMoveTest() {
        model.setDistance(1000);
        model.setAcceleration(10);
        model.setMaxSpeed(50);
        model.setDelay(5);

        uniformUniformStrategy = new UniformlyAcceleratedWithNoStartingSpeedStrategy();
        UniformModel phase1 = uniformUniformStrategy.move(model);

        uniformUniformStrategy = new UniformlyDelayedStrategy();
        UniformModel phase2 = uniformUniformStrategy.move(model);

        UniformModel result = new UniformModel(model);
        result.setDistance(result.getDistance() - (phase1.getDistance() + phase2.getDistance()));

        uniformUniformStrategy = new UniformMoveStrategy();
        UniformModel phase3 = uniformUniformStrategy.move(result);

        result.setTime(phase1.getTime() + phase2.getTime() + phase3.getTime());

        double expected = 27.5;

        System.out.println("expected time: " + expected + "\n"
                + "actual: " + result.getTime());

        Assert.assertEquals(result.getTime(), expected, 0);
    }

}
