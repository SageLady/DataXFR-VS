module rmesser.dataxfr {
    requires javafx.controls;
    requires javafx.fxml;


    opens rmesser.dataxfr to javafx.fxml;
    exports rmesser.dataxfr;
}