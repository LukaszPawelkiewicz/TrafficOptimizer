package test.classes.model.simulation;


import mvc.model.road.Route;
import mvc.model.road.common.EndPoint;
import mvc.model.road.common.Road;
import mvc.model.road.common.StartPoint;
import mvc.model.road.object.RoadObject;
import mvc.model.simulation.observer.common.RoadObjectObserver;
import org.junit.Test;
import org.junit.Assert;

public class RoadObjectObserverTest {

    @Test
    public void addingToRoadObserverTest() {
        System.out.println("RoadObserver Test");

        StartPoint startPoint = new StartPoint(1, 1, RoadObjectObserver.getInstance());
        EndPoint endPoint = new EndPoint(1, 3, RoadObjectObserver.getInstance());
        Road road = new Road(1, 3, 50, 30, 50, RoadObjectObserver.getInstance());
        Road road1 = new Road(2, 4, 100, 30, 50, RoadObjectObserver.getInstance());

        Route route = new Route(startPoint, endPoint);

        for (RoadObject roadObject : RoadObjectObserver.getRoadObjects()) {
            System.out.println(roadObject.getX() + " " + roadObject.getY() + " " + roadObject.getLength());
        }

        Assert.assertNotNull(RoadObjectObserver.getRoadObjects());
    }

}
