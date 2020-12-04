package ch.bfh.trafficLight;

import java.util.HashSet;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.concurrent.Task;

/**
 * A simple traffic light with its business logic.
 * 
 * @author marcel.pfahrer[at]bfh.ch
 */
public class TrafficLight 
    extends Task<Void> 
    implements Observable {

    public static final String OFF = "OFF";
    public static final String WARNING = "WARNING";
    public static final String GREEN = "GREEN";
    public static final String YELLOW = "YELLOW";
    public static final String RED = "RED";

    static final int DURATION_GREEN = 15;
    static final int DURATION_YELLOW = 3;
    static final int DURATION_RED = 10;

    String status = OFF;
    boolean greenOn = false;
    boolean yellowOn = false;
    boolean redOn = false;
    int duration = 0;

    public TrafficLight() {
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String newStatus, boolean green, boolean yellow, boolean red) {
        
        System.out.println(status + " -> " + newStatus);
        
        status = newStatus;
        
        greenOn = green;
        yellowOn = yellow;
        redOn = red;
        
        duration = 0;

        notifyListeners();
    }

    public void switchOn() {
        if (status == OFF || status == WARNING) {
            setStatus(GREEN, true, false, false);
        }
    }

    public void switchOff() {
        setStatus(OFF, false, false, false);
    }

    public void switchWarning() {
        setStatus(WARNING, false, true, false);
    }

    public boolean isGreenOn() {
        return greenOn;
    }

    public boolean isYellowOn() {
        return yellowOn;
    }

    public boolean isRedOn() {
        return redOn;
    }

    @Override
    public Void call() throws Exception {
        try {
            while (true) {
                duration++;
                System.out.print(".");

                if (status == WARNING) {
                    setStatus(WARNING, false, !yellowOn, false);
                }
                else if (status == GREEN && duration >= DURATION_GREEN) {
                    setStatus(YELLOW, false, true, false);
                }
                else if (status == YELLOW && duration >= DURATION_YELLOW) {
                    setStatus(RED, false, false, true);
                }
                else if (status == RED && duration >= DURATION_RED) {
                    setStatus(GREEN, true, false, false);
                }

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
}