module rmesser.dataxfr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens rmesser.dataxfr to javafx.fxml;
    exports rmesser.dataxfr;
}