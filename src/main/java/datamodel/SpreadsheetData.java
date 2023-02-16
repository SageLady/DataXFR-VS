package datamodel;

import javafx.collections.ObservableList;

import java.time.format.DateTimeFormatter;

public class SpreadsheetData {
    private static SpreadsheetData instance = new SpreadsheetData();
    private static String filename = "TodoListItems.txt";
    // private List<TodoItem> todoItems;
    private ObservableList<Spreadsheet> todoItems;
    private DateTimeFormatter formatter;

    public static SpreadsheetData getInstance() {
        return instance;
    }

    private SpreadsheetData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void addTodoItem(Spreadsheet item){

    }


}
