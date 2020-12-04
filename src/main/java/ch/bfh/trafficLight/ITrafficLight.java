package ch.bfh.trafficLight;

import ch.bfh.trafficLight.states.State;

public interface ITrafficLight {
    void setState(State state);
    void setTimer(int seconds);
    void setLights(boolean green, boolean yellow, boolean red);
}
