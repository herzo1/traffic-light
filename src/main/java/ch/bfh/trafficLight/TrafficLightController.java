package ch.bfh.trafficLight;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

/**
 * JavaFX controller for the traffic light example.
 * 
 * @author marcel.pfahrer[at]bfh.ch
 */
public class TrafficLightController implements Initializable, InvalidationListener {

    TrafficLight trafficLight;

    @FXML Circle lightGreen;
    @FXML Circle lightYellow;
    @FXML Circle lightRed;

    @FXML Button btnOn;
    @FXML Button btnOff;
    @FXML Button btnWarning;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trafficLight = TrafficLight.getInstance();
        trafficLight.addListener(this);
    }

    @Override
    public void invalidated(Observable observable) {
        
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                lightGreen.setOpacity((trafficLight.isGreen()) ? 1.0 : 0.15);
                lightYellow.setOpacity(trafficLight.isYellow() ? 1.0 : 0.15);
                lightRed.setOpacity(trafficLight.isRed() ? 1.0 : 0.15);
            }

        });
    }

    @FXML 
    private void onBtnOn() {
    	trafficLight.switchOn();
    	btnOn.setDefaultButton(true);
    	btnOff.setDefaultButton(false);
    	btnWarning.setDefaultButton(false);
    }
    
    @FXML 
    private void onBtnOff() {
    	trafficLight.switchOff();
    	btnOn.setDefaultButton(false);
    	btnOff.setDefaultButton(true);
    	btnWarning.setDefaultButton(false);
    }
    
    @FXML 
    private void onBtnWarning() {
    	trafficLight.switchWarning();
    	btnOn.setDefaultButton(false);
    	btnOff.setDefaultButton(false);
    	btnWarning.setDefaultButton(true);
    }
}
