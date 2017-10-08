package mvc.model.simulation.engine.factory;

import mvc.model.road.RouteRoadObject;
import mvc.model.road.common.Road;
import mvc.model.simulation.engine.data.UniformModel;
import mvc.model.vehicle.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UniformModelFactory {

    public static List<UniformModel> crateModels(Vehicle vehicle) {
        List<UniformModel> result = new ArrayList<>();

        for (RouteRoadObject routeRoadObject : vehicle.getRoute().getPath()) {
            if (routeRoadObject.getCurrent().getLength() != 0 && routeRoadObject.getCurrent().getClass() == Road.class) {
                Road road = (Road) routeRoadObject.getCurrent();
                UniformModel model = new UniformModel(road.getMaxStartingSpeed(), road.getMaxAllowedSpeed(), road.getLength(), vehicle.getAcceleration(), vehicle.getDelay());
                model.setNext(routeRoadObject.getNext().getClass());
                result.add(model);
            }
        }

        return result;
    }

}
