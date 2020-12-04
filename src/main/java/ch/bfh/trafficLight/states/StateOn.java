package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public abstract class StateOn extends State {
    public StateOn(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    abstract public void onEnter();
    abstract public void handleTimer();

    public void handleWarning() {

    }

    public void handleOff() {

    }
}
