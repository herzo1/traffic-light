module ch.bfh.trafficLight {
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

    opens ch.bfh.trafficLight to javafx.fxml;
    exports ch.bfh.trafficLight;
    exports ch.bfh.trafficLight.states;
}