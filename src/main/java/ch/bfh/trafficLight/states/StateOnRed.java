package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public class StateOnRed extends StateOn{
    private static final int DURATION = 8;

    public StateOnRed(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    public void onEnter() {

    }

    public void handleTimer() {

    }
}
