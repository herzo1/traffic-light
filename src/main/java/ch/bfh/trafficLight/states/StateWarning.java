package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public class StateWarning extends State {
    private static int DURATION = 1;
    private boolean isOn = false;

    public StateWarning(ITrafficLight trafficLight) {
        super(trafficLight);
    }

    public void onEnter() {

    }

    public void handleOn() {

    }

    public void handleOff() {

    }

    public void handleTimer() {

    }

}
