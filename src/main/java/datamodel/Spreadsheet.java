package datamodel;

import java.time.LocalDate;

public class Spreadsheet {


    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public Spreadsheet(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }


}
