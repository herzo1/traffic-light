package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public class StateOnYellow extends StateOn{
    private static final int DURATION = 3;

    public StateOnYellow(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    public void onEnter() {
        super.trafficLight.setLights(false, true, false);
        super.trafficLight.setTimer(DURATION);
    }

    public void handleTimer() {
        super.trafficLight.setState(new StateOnRed(super.trafficLight));
    }
}
