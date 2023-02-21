package datamodel;

import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

public class XLSXReader {
    private String author;
    private String lastSavedTime;
    private String title;

    private File file;
    private FileInputStream fis;
    private XSSFWorkbook workbook;
    private String directory;

    //CONSTRUCTOR:
    public XLSXReader(String dir) {
        try {
            file = new File(dir); //Creating new file instance
            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(file);
            directory = dir;
        }   catch(Exception e)
        {
            System.out.println("Inside XLSXReader constructor: " + e.getMessage());
        }
    } //END constructor

    public void getXLSXMeta() {
        XSSFWorkbook xlsxGetMetadata =  workbook;
        xlsxGetMetadata.createSheet("Test sheet");
        POIXMLProperties props = xlsxGetMetadata.getProperties();
        int sheetCount = xlsxGetMetadata.getNumberOfSheets();
        POIXMLProperties.CoreProperties coreProperties = xlsxGetMetadata.getProperties().getCoreProperties();
        Date created = coreProperties.getCreated();
        String creator = coreProperties.getCreator();
        String lastModifiedByUser = coreProperties.getLastModifiedByUser();
        String title1 = coreProperties.getTitle();
        String contentStatus = coreProperties.getContentStatus();
        String contentType = coreProperties.getContentType();
        Date modified = coreProperties.getModified();
        Date lastPrinted = coreProperties.getLastPrinted();

        System.out.println(props);
        System.out.println("Sheet count: " + sheetCount);
        System.out.println("date created: " + created);
        System.out.println("creator: " + creator);
        System.out.println("Last modified by user: " + lastModifiedByUser);
        System.out.println("Title of workbook: " + title1);
        System.out.println("Content Status: " + contentStatus);
        System.out.println("Content type: " + contentType);
        System.out.println("Modified date: " + modified);
        System.out.println("Last time printed date: " + lastPrinted);

    }

}

/*

// Create an instance of Parser class
try (Parser parser = new Parser(Constants.SampleXlsx)) {
        // Extract metadata from the spreadsheet
        Iterable<MetadataItem> metadata = parser.getMetadata();
        // Iterate over metadata items
        for (MetadataItem item : metadata) {
        // Print an item name and value
        System.out.println(String.format("%s: %s", item.getName(), item.getValue()));
        }
        }
*/
