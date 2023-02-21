package rmesser.dataxfr;

import datamodel.Datasource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class MainMenuApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Data Transfer Application");
        stage.setScene(scene);
        stage.show();

    }


    /*  Module 381 - JDBC with a GUI program
    Using javaFX lifecycle methods init() and stop() to open and close our database. WE override them
    and then enter our code we need to perform the db tasks. By default, these two Application class methods
    do not do anything thereby allowing us to use them as shown below.
    */
    @Override
    public void init() throws Exception {
        super.init();   //Not doing anything but keeping for future changes
        if(!Datasource.getInstance().open()) {
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();   //Not doing anything but keeping for future changes
        Datasource.getInstance().close();
    }

    public static void main(String[] args) {
        launch();
    }
}