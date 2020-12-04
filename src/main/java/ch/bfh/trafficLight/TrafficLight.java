package ch.bfh.trafficLight;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.concurrent.Task;

import java.util.HashSet;
import java.util.Timer;

/**
 * A simple traffic light with its business logic.
 * 
 * @author marcel.pfahrer[at]bfh.ch
 */
public class TrafficLight
    extends Task<Void> 
    implements Observable, ITrafficLight {

    private ch.bfh.trafficLight.states.State state;
    private Timer timer;

    boolean green = false;
    boolean yellow = false;
    boolean red = false;

    public TrafficLight() {
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
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

    @Override
    public Void call() throws Exception {
        try {
            while (true) {
                // Todo: implement timer here


                Thread.sleep(1000);
            }
        } 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return null;
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
    }

    @Override
    public void setTimer(int seconds) {

    }

    @Override
    public void setLights(boolean green, boolean yellow, boolean red) {
        this.green = green;
        this.yellow = yellow;
        this.red = red;
    }
}