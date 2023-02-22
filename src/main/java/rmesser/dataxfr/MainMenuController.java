package rmesser.dataxfr;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class MainMenuController {
    @FXML
    private BorderPane mainBorderPane;
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\19255\\IdeaProjects\\Mod356CreatingDatabases\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    @FXML
    protected void showNewWorkbookDialog() {
        String mainMessage = null;
        String title = null;
        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(this.mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Workbook");
        dialog.setHeaderText("Steps: 1. Set Path 2. Load ");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("new-workbook-dialog.fxml"));

        try {
            dialog.getDialogPane().setContent((Node)fxmlLoader.load());
        } catch (IOException | IOError var8) {
            String var10000 = var8.getMessage();
            mainMessage = "Message: " + var10000 + "\nStackTrace: " + Arrays.toString(var8.getStackTrace());
            title = var8.getClass().getName();
            System.out.println("couldn't load the dialog:\n");
            System.out.println(mainMessage);
            System.out.println(title);
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            NewWorkbookDialogController controller = (NewWorkbookDialogController) fxmlLoader.getController();
        }

    } //END showNewWorkbookDialog

    @FXML
    protected void showNewOwnerDialog() {
        String mainMessage = null;
        String title = null;
        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(this.mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Owner");
        dialog.setHeaderText("Steps: 1. Add owner if not present in owner's list.");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("new-owner-dialog.fxml"));

        try {
            dialog.getDialogPane().setContent((Node)fxmlLoader.load());
        } catch (IOException | IOError var8) {
            String var10000 = var8.getMessage();
            mainMessage = "Message: " + var10000 + "\nStackTrace: " + Arrays.toString(var8.getStackTrace());
            title = var8.getClass().getName();
            System.out.println("couldn't load the dialog:\n");
            System.out.println(mainMessage);
            System.out.println(title);
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            NewOwnerDialogController controller = (NewOwnerDialogController) fxmlLoader.getController();
        }

    }  //END showNewOwnerDialog

    @FXML
    public void handleExit() {
        Platform.exit();
    }

    @FXML
    public void handleFilterButton() {

    }

    @FXML
    public void handleKeyPressed() {

    }


} //END MainMenuController