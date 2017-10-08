package mvc.model.simulation.engine.data;

public class UniformModel {

    private double startingSpeed;
    private double maxSpeed;
    private double time;
    private double distance;
    private double acceleration;
    private double delay;
    private Class next;

    public UniformModel() {
    }

    /**
     * Use to simulate time
     *
     * @param startingSpeed starting speed
     * @param maxSpeed      max speed on road
     * @param distance      distance to move
     * @param acceleration  acceleration of vehicle
     * @param delay         delay of vehicle
     */
    public UniformModel(double startingSpeed, double maxSpeed, double distance, double acceleration, double delay) {
        this.startingSpeed = startingSpeed;
        this.maxSpeed = maxSpeed;
        this.distance = distance;
        this.acceleration = acceleration;
        this.delay = delay;
    }

    public UniformModel(UniformModel model) {
        this.setStartingSpeed(model.getStartingSpeed());
        this.setMaxSpeed(model.getMaxSpeed());
        this.setTime(model.getTime());
        this.setDistance(model.getDistance());
        this.setAcceleration(model.getAcceleration());
        this.setDelay(model.getDelay());
        this.setNext(model.getNext());
    }

    public double getStartingSpeed() {
        return startingSpeed;
    }

    public void setStartingSpeed(double startingSpeed) {
        this.startingSpeed = startingSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public Class getNext() {
        return next;
    }

    public void setNext(Class next) {
        this.next = next;
    }
}
