package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public abstract class StateOn extends State {
    public StateOn(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    public void handleOn() {
        // do nothing...
    }

    abstract public void onEnter();
    abstract public void handleTimer();
}
