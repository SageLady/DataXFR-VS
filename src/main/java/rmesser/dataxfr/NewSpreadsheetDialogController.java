package rmesser.dataxfr;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;

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
    public void initialize(){
        HBOX_Load.setVisible(false);
        loadButton.setVisible(false);
        loadInstructions.setVisible(false);
        path.setEditable(false);
        filename.setEditable(false);

//        buttonFour.setEffect(new DropShadow());


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


/*
        filename.setOnAction(actionEvent -> {
            String name = filename.getText();
            if(name.isEmpty()){
                HBOX_Load.setVisible(false);
                loadButton.setVisible(false);
                loadInstructions.setVisible(false);
            }
        });
*/


    } //END initialize


        /*

            filename.textProperty().addListener((observable, oldValue, newValue) -> {
            String name = observable.getValue();
            if(name == null ) {
                HBOX_Load.setVisible(false);
                loadButton.setVisible(false);
                loadInstructions.setVisible(false);
            }
        });




        formLookup.textProperty().addListener((observable, oldValue, newValue) -> {
            String copy = observable.getValue();
            if (newValue.length() > max) {
                copy = copy.substring(0, max);
                formLookup.setText(copy);
            }
            if (newValue.length() < max) {
                formSearch.setDisable(true);
                formSearchResult.setText("");
            }
            if (newValue.length() == max) {
                formSearch.setDisable(false);
                formSearch.requestFocus(); // Delegate the focus to results label
            }
        });
*/



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

    }



} //END NewSpreadsheetDialogController
