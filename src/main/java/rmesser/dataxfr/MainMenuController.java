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


    @FXML
    protected void showNewSheetDialog() {
        String mainMessage = null;
        String title = null;
        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(this.mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Spreadsheet");
        dialog.setHeaderText("Use this dialog to add spreadsheet details");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("new-spreadsheet-dialog.fxml"));

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
            NewSpreadsheetDialogController controller = (NewSpreadsheetDialogController) fxmlLoader.getController();
        }

    }


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