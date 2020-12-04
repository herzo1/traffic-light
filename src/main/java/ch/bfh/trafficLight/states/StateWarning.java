package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public class StateWarning extends State {
    private static int DURATION = 1;
    private boolean isOn = false;

    public StateWarning(ITrafficLight trafficLight) {
        this(trafficLight, true);
    }

    private StateWarning(ITrafficLight trafficLight, boolean isOn) {
        super(trafficLight);
        this.isOn = isOn;
    }

    public void handleWarning() {
        // do nothing...
    }

    public void onEnter() {
        super.trafficLight.setLights(false, isOn, false);
        super.trafficLight.setTimer(DURATION);
    }

    public void handleTimer() {
        super.trafficLight.setState(new StateWarning(super.trafficLight, ! isOn));
    }

}
