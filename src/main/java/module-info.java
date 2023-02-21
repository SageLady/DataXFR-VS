module rmesser.dataxfr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens rmesser.dataxfr to javafx.fxml;
    exports rmesser.dataxfr;
}