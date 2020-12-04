package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public class StateOff extends State {
    public StateOff(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    @Override
    public void onEnter() {
        super.trafficLight.setLights(false, false, false);
    }
}
