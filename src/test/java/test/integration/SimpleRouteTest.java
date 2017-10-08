package test.integration;

import mvc.model.road.Route;
import mvc.model.road.RouteRoadObject;
import mvc.model.road.common.Crossing;
import mvc.model.road.common.EndPoint;
import mvc.model.road.common.Road;
import mvc.model.road.common.StartPoint;
import mvc.model.simulation.engine.PhysicsEngine;
import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.simulation.engine.factory.UniformModelFactory;
import mvc.model.simulation.observer.common.RoadObjectObserver;
import mvc.model.simulation.observer.common.VehicleObserver;
import mvc.model.vehicle.common.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleRouteTest {

    private Route route;

    @BeforeEach
    public void setUp() {
        route = new Route();
    }

    @Test
    public void routeTest() {
        StartPoint startPoint = new StartPoint(1, 1, RoadObjectObserver.getInstance());
        EndPoint endPoint = new EndPoint(5, 1, RoadObjectObserver.getInstance());
        Road road = new Road(2, 1, 1000, 50, 70, RoadObjectObserver.getInstance());
        Road road1 = new Road(3, 1, 500, 30, 50, RoadObjectObserver.getInstance());
        Road road2 = new Road(4, 1, 200, 30, 50, RoadObjectObserver.getInstance());

        route.setStartPoint(startPoint);
        route.activateStart();

        route.addNextRoadObjectToPath(road);
        route.addNextRoadObjectToPath(road1);
        route.addNextRoadObjectToPath(road2);
        route.addInsideRoadObjectTopath(new Crossing(2, 2, RoadObjectObserver.getInstance()), 2);

        route.setEndPoint(endPoint);
        route.activateEnd();

        route.sumDistance();

        Car car = new Car(10, 15, 7, VehicleObserver.getInstance());
        car.setRoute(route);

        PhysicsEngine physicsEngine = new PhysicsEngine(car);
        List<UniformModel> models = UniformModelFactory.crateModels(car);
        List<UniformModel> results = new ArrayList<>();
        for (UniformModel model : models) {
            physicsEngine.setModel(model);
            physicsEngine.moveSimulation();
            results.add(physicsEngine.getModel());
        }

        System.out.println("Distance: " + route.getDistance());
        for (RouteRoadObject pathObject : route.getPath()) {
            System.out.println(pathObject.getCurrent() + " " + pathObject.getNext());
        }
        for (UniformModel model : results) {
            System.out.println(model + " " +
                    model.getMaxSpeed() + " " +
                    model.getDistance() + " " +
                    model.getAcceleration() + " " +
                    model.getDelay() + " " +
                    model.getTime()
            );
        }

    }

}
