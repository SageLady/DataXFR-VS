package rmesser.dataxfr;

import datamodel.Owner;
import datamodel.XLSXReader;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class NewSpreadsheetDialogController {
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField path;

    @FXML
    private TextField filename;
    @FXML
    private HBox HBOX_Load;
    @FXML
    private Button loadButton;
    @FXML
    private Label loadInstructions;
    @FXML
    ProgressBar progressBar;  //Module 385
    @FXML
    private HBox HBOX_Owner;
    @FXML
    private Label ownerLabel;
    @FXML
    private ComboBox ownerComboBox;

    public void initialize(){

        System.setProperty("log4j.configurationFile","./path_to_the_log4j2_config_file/log4j2.xml");

        Logger log = LogManager.getLogManager().getLogger("logFile");

        HBOX_Load.setVisible(false);
        loadButton.setVisible(false);
        loadInstructions.setVisible(false);
        path.setEditable(false);
        filename.setEditable(false);
        HBOX_Owner.setVisible(false);
        ownerLabel.setVisible(false);
        ownerComboBox.setVisible(false);


        path.textProperty().addListener((observable, oldValue, newValue) -> {
            String dir = observable.getValue();
            if(!dir.isEmpty()) {
                HBOX_Load.setVisible(true);
                loadButton.setVisible(true);
                loadInstructions.setVisible(true);
            } else {
                HBOX_Load.setVisible(false);
                loadButton.setVisible(false);
                loadInstructions.setVisible(false);
            }
        });

        filename.textProperty().addListener((observable, oldValue, newValue) -> {
            String name = observable.getValue();
            if(!name.isEmpty()) {
                HBOX_Load.setVisible(true);
                loadButton.setVisible(true);
                loadInstructions.setVisible(true);
            } else {
                HBOX_Load.setVisible(false);
                loadButton.setVisible(false);
                loadInstructions.setVisible(false);
            }
        });


    } //END initialize

    @FXML
        public void directoryButtonHandleClick() {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Add Excel file");
            //defining extensions serves to show users the available file types
            //that can be used for a given utility or how a file should be saved.
            //Also, the method ExtensionFilter will only display the files
            //with either the PDF or txt extension.
            chooser.getExtensionFilters().addAll(
                    //If you want to limit what is display on Windows/ Mac
                    //use extension filter
                    new FileChooser.ExtensionFilter("Excel","*.xlsx")
            );
            //Multiple files open: List<File> file
            //List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
            //Single Open:
            File file = chooser.showOpenDialog(gridPane.getScene().getWindow());
            //File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
            if(file != null){
                //Single file open/save
                 System.out.println(file.getPath());
                 path.setText(file.getPath());
                 filename.setText(file.getName());
                //Multiple print out:
               //Original:   for(int i=0; i<file.size();i++){
                //Original:    System.out.println(file.get(i));
                //Original:   }
                 } else {
                System.out.println("Chooser was cancelled");
            }
    } //END directoryButtonHandleClick

    @FXML
    public void loadButtonHandleClick() {
        //Check metadata of spreadsheet:
        XLSXReader reader = new XLSXReader(path.getText());
        reader.getXLSXMeta();

        Task<ObservableList<Owner>> task = new GetAllOwnersTask();
        ownerComboBox.itemsProperty().bind(task.valueProperty());

        //Module 385:
        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));  //IF success make invisible
        task.setOnFailed(e -> progressBar.setVisible(false));   //IF fail make invisible

        new Thread(task).start();


    }

} //END NewSpreadsheetDialogController


class GetAllOwnersTask extends Task {
    @Override
    public ObservableList<Owner> call()  {
        try {
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            System.out.println("Observable Interrupted: " + e.getMessage());
        }
        return null;
        //Original:
        //return FXCollections.observableArrayList
        //        (DatasourceOwner.getInstance().queryOwners(DatasourceOwner.ORDER_BY_ASC));
    }
} //END GetAllOwnersTask

