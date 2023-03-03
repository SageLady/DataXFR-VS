package rmesser.dataxfr;

import datamodel.Datasource;
import datamodel.Owner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class NewOwnerDialogController {
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField ownerName;
    @FXML
    private Label messageLabel;
    @FXML
    private TableView ownerTable;
    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label successLabel;
    @FXML
    private Button showAll;
   Datasource datasource = new Datasource();
   public void initialize() throws Exception {

       if(!Datasource.getInstance().open()) {
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }

       ownerName.setTextFormatter(new TextFormatter<>((change) -> {
           change.setText(change.getText().toUpperCase());
           return change;
       }));


   } //END initialize


    public void close() throws Exception {
      Datasource.getInstance().close();
    }
        @FXML
    protected void showOwnersButtonHandleClick() {
           System.out.println("inside click");
           int result =   Datasource.getInstance().EmptyTableQuery(Datasource.TABLE_OWNERS);
           if(result == -1 ) {
                 messageLabel.setVisible(true);
                 messageLabel.setText("Empty table. Add owner's to populate list.");
                 return;
             }

            messageLabel.setVisible(false);
           //Query owners and display list
            Task<ObservableList<Owner>> task = new GetAllOwnersTask();
            ownerTable.itemsProperty().bind(task.valueProperty());
            //Module 385:

            progressBar.progressProperty().bind(task.progressProperty());
            progressBar.setVisible(true);

            task.setOnSucceeded(e -> progressBar.setVisible(false));  //IF success make invisible
            task.setOnFailed(e -> progressBar.setVisible(false));   //IF fail make invisible

            new Thread(task).start();
    }

    @FXML
    protected void addOwnerButtonHandleClick() {
        successLabel.setVisible(false);
       if(ownerName.getText().equals("")){
           messageLabel.setVisible(true);
           messageLabel.setText("Please add name of owner in name field.");
            return;
       }

       int result = Datasource.getInstance().getOwnerId(ownerName.getText());
        if(result != -2) {
            messageLabel.setVisible(true);
            messageLabel.setText("Owner name already exists");
            return;
        }
        messageLabel.setText("");
        AddOwnerTask task = new AddOwnerTask(ownerName.getText()){
            @Override
            protected Integer call() throws Exception {
                int r = Datasource.getInstance().insertOwner(name);
                return r;
            }
        };

        task.setOnSucceeded(e -> successLabel.setVisible(true));
        new Thread(task).start();

    }  //AddOwnerHandleClick

} //END NewOwnerDialogController


class GetAllOwnersTask extends Task {
    @Override
    public ObservableList<Owner> call()  {

        return FXCollections.observableArrayList
               (Datasource.getInstance().queryOwner(Datasource.ORDER_BY_ASC));
    }

} //END GetAllOwnersTask

 abstract class AddOwnerTask extends Task<Integer> {
    protected String name;
    public AddOwnerTask(String name) {
        this.name = name;
    }
}  //END AddOwnerTask







/*
    @FXML //---> Module 385 - Added @FXML to add event handler for list Artist button
    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        //Module 385:
        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));  //IF success make invisible
        task.setOnFailed(e -> progressBar.setVisible(false));   //IF fail make invisible

        new Thread(task).start();
    }*/


/*

    @FXML
    public void updateArtist() {
//        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();  //Used when dialog box used to get data entry
//        final Artist artist = (Artist) artistTable.getItems().get(2);  //AC DC is on row 2, rows start from zero.

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return Datasource.getInstance().updateArtistName(artist.getId(), "AC/DC");
            }
        };

        task.setOnSucceeded(e -> {
            if(task.valueProperty().get()) {
                artist.setName("AC/DC");
                artistTable.refresh();
            }
        });

        new Thread(task).start();
    }  //END updateArtist


*/