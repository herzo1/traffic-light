package ch.bfh.trafficLight.states;

import ch.bfh.trafficLight.ITrafficLight;

public abstract class State {
    protected final ITrafficLight trafficLight;

    public State(ITrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }


    abstract public void onEnter();
    public void handleWarning() {
        this.trafficLight.setState(new StateWarning(this.trafficLight));
    }

    public void handleOn() {
        this.trafficLight.setState(new StateOnRed(this.trafficLight));
    }

    public void handleOff() {
        this.trafficLight.setState(new StateOff(this.trafficLight));
    }

    public void handleTimer() {
        this.trafficLight.setTimer(0);
    }
}
