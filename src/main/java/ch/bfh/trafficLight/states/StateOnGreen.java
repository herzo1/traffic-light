package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public class StateOnGreen extends StateOn {
    private static final int DURATION = 12;

    public StateOnGreen(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    public void onEnter() {

    }

    public void handleTimer() {

    }
}
