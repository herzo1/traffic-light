package ch.bfh.trafficLight;

import ch.bfh.trafficLight.states.StateOff;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.concurrent.Task;

import java.util.HashSet;

/**
 * A simple traffic light with its business logic.
 * 
 * @author marcel.pfahrer[at]bfh.ch
 */
public class TrafficLight
    implements Observable, ITrafficLight {

    private ch.bfh.trafficLight.states.State state;

    private Thread t;

    private boolean green = false;
    private boolean yellow = false;
    private boolean red = false;

    public TrafficLight() {
        this.state = new StateOff(this);
    }

    public void switchOn() {
        this.state.handleOn();
    }

    public void switchOff() {
        this.state.handleOff();
    }

    public void switchWarning() {
        this.state.handleWarning();
    }

    public boolean isGreen() {
        return green;
    }

    public boolean isYellow() {
        return yellow;
    }

    public boolean isRed() {
        return red;
    }

    // DONE implement Observer pattern and interface

    HashSet<InvalidationListener> listeners = new HashSet<InvalidationListener>();

    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for(InvalidationListener l : listeners) {
            l.invalidated(this); // notification
        }
    }

    // DONE implement Singleton pattern

    static TrafficLight instance = new TrafficLight();

    public static TrafficLight getInstance() {

        return instance;
    }

    @Override
    public void setState(ch.bfh.trafficLight.states.State state) {
        this.state = state;
        this.state.onEnter();
    }

    @Override
    public void setTimer(int seconds) {
        if (t != null && t.isAlive()) {
            t.interrupt();
        }
        t = new Thread(() -> {
                try {
                    Thread.sleep(seconds * 1000);
                    state.handleTimer();
                } catch (InterruptedException ignored) {
                }
            });
        t.start();
    }

    @Override
    public void setLights(boolean green, boolean yellow, boolean red) {
        this.green = green;
        this.yellow = yellow;
        this.red = red;
        this.notifyListeners();
    }
}