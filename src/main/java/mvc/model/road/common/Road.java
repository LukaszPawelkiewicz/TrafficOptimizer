package mvc.model.road.common;

import mvc.model.road.object.RoadObject;
import mvc.model.simulation.observer.Observer;
import mvc.model.simulation.observer.common.RoadObjectObserver;

public class Road extends RoadObject {

    private final RoadObject[] points = new RoadObject[2];
    private double maxStartingSpeed;
    private double maxAllowedSpeed;

    public Road(int x, int y, long length, double maxStartingSpeed, double maxAllowedSpeed, RoadObjectObserver observer) {
        super(observer);
        this.length = length;
        this.x = x;
        this.y = y;
        this.maxStartingSpeed = maxStartingSpeed;
        this.maxAllowedSpeed = maxAllowedSpeed;
    }

    public void setPoint1(RoadObject roadObject) {
        this.points[0] = roadObject;
    }

    public RoadObject getPoint1() {
        return points[0];
    }

    public void setPoint2(RoadObject roadObject) {
        this.points[1] = roadObject;
    }

    public RoadObject getPoint2() {
        return points[1];
    }

    public double getMaxStartingSpeed() {
        return maxStartingSpeed;
    }

    public void setMaxStartingSpeed(double maxStartingSpeed) {
        this.maxStartingSpeed = maxStartingSpeed;
    }

    public double getMaxAllowedSpeed() {
        return maxAllowedSpeed;
    }

    public void setMaxAllowedSpeed(double maxAllowedSpeed) {
        this.maxAllowedSpeed = maxAllowedSpeed;
    }
}
