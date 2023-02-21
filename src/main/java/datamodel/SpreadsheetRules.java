package datamodel;

import javafx.collections.ObservableList;

import java.time.format.DateTimeFormatter;

public class SpreadsheetRules {
    private static SpreadsheetRules instance = new SpreadsheetRules();
    private static String filename = "TodoListItems.txt";
    // private List<TodoItem> todoItems;
    private ObservableList<Spreadsheet> todoItems;
    private DateTimeFormatter formatter;

    public static SpreadsheetRules getInstance() {
        return instance;
    }

    private SpreadsheetRules() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void addTodoItem(Spreadsheet item){

    }


}
