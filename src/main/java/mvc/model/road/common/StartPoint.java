package mvc.model.road.common;

import mvc.model.road.object.RoadObject;
import mvc.model.simulation.observer.Observer;
import mvc.model.simulation.observer.common.RoadObjectObserver;

public class StartPoint extends RoadObject {

    /**
     * new starting point
     *
     * @param x        position x
     * @param y        position y
     * @param observer observer
     */
    public StartPoint(int x, int y, RoadObjectObserver observer) {
        super(observer);
        this.x = x;
        this.y = y;
    }

}
