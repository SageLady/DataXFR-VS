package datamodel;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {

    public static final String DB_NAME = "dataXFR.db";
    public static final String SEPARATOR =  File.separator;
    public static final String SELECT_ = "SELECT ";
    public static final String DOT = ".";
    public static final String _FROM_ = " FROM ";
    public static final String _INNER_JOIN_ = " INNER JOIN ";
    public static final String _ON_ = " ON ";
    public static final String _EQUAL_ = " = ";
    public static final String _WHERE_ = " WHERE ";
    public static final String DBLQUOTE = "\"";
    public static final String _ORDER_BY_ = " ORDER BY ";
    public static final String _COLLATE_NOCASE_ = " COLLATE NOCASE ";
    public static final String  DESCENDING  = "DESC";
    public static final String ASCENDING   = "ASC";
    public static final String SQL_STATEMENT_EQUALS = "SQL statement equals: ";



    //    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;
    public static final String CONNECTION_STRING =
            "jdbc:sqlite:C:" + SEPARATOR + "Users" + SEPARATOR  + "19255" + SEPARATOR  +
                    "IdeaProjects" + SEPARATOR  + "DataXFR-VS" + SEPARATOR  + DB_NAME;

    //*************** OWNERS TABLE VARS:
    public static final String TABLE_OWNERS = "owners";
    public static final String COLUMN_OWNER_ID = "_id";
    public static final String COLUMN_OWNER_NAME = "name";
    public static final int INDEX_OWNER_ID = 1;
    public static final int INDEX_OWNER_NAME = 2;

    //*************** WORKBOOK TABLE VARS:
    public static final String TABLE_WORKBOOKS = "workbooks";
    public static final String COLUMN_WORKBOOK_ID = "_id";
    public static final String COLUMN_WORKBOOK_NAME = "name";
    public static final String COLUMN_WORKBOOK_DIRECTORY = "directory";
    public static final String COLUMN_WORKBOOK_SHEET_COUNT = "sheetCount";
    public static final String COLUMN_WORKBOOK_SHEET_NAMES = "sheetNames";
    public static final String COLUMN_WORKBOOK_OWNER = "owner";
    public static final String COLUMN_WORKBOOK_OWNER_ID = "_idOwner";
    public static final int INDEX_WORKBOOK_ID = 1;
    public static final int INDEX_WORKBOOK_NAME = 2;
    public static final int INDEX_WORKBOOK_DIRECTORY = 3;
    public static final int INDEX_WORKBOOK_SHEET_COUNT = 4;
    public static final int INDEX_WORKBOOK_SHEET_NAMES = 5;
    public static final int INDEX_WORKBOOK_OWNER = 6;
    public static final int INDEX_WORKBOOK_OWNER_ID = 7;

    //*************** SPREADSHEET TABLE VARS:
    public static final String TABLE_SHEETS = "sheets";
    public static final String COLUMN_SHEET_ID = "_id";
    public static final String COLUMN_SHEET_NAME = "name";
    public static final String COLUMN_SHEET_NUMBER = "sheetNumber";
    public static final String COLUMN_SHEET_Y_HEADER_ROW = "headerY";   //Column headings
    public static final String COLUMN_SHEET_Y_HEADER_NAMES = "headerYNames";
    public static final String COLUMN_SHEET_X_HEADER_COLUMN = "headerX";   //Row headings
    public static final String COLUMN_SHEET_X_HEADER_NAMES = "headerXNames";
    public static final String COLUMN_SHEET_WORKBOOK_NAME = "wbName";
    public static final String COLUMN_SHEET_WORKBOOK_DIR = "wbDir";
    public static final String COLUMN_SHEET_WORKBOOK_OWNER = "owner";
    public static final String COLUMN_SHEET_WORKBOOK_OWNER_ID = "_idOwner";
    public static final int INDEX_SHEET_ID = 1;
    public static final int INDEX_SHEET_NAME = 2;
    public static final int INDEX_SHEET_NUMBER = 3;
    public static final int INDEX_SHEET_Y_HEADER_ROW = 4;   //Column headings
    public static final int INDEX_SHEET_Y_HEADER_NAMES = 5;
    public static final int INDEX_SHEET_X_HEADER_COLUMN = 6;   //Row headings
    public static final int INDEX_SHEET_X_HEADER_NAMES = 7;
    public static final int INDEX_SHEET_WORKBOOK_NAME = 8;
    public static final int INDEX_SHEET_WORKBOOK_DIR = 9;
    public static final int INDEX_SHEET_WORKBOOK_OWNER = 10;
    public static final int INDEX_SHEET_WORKBOOK_OWNER_ID = 11;

    //*************** SPREADSHEET RULES TABLE VARS:
    public static final String TABLE_RULES = "rules";
    public static final String COLUMN_RULE_ID = "_id";
    public static final String COLUMN_RULE_NAME = "name";   //I will auto-create rule name--> _id + rule + sourceWBId + "swb" + destWBId + "dwb"
    public static final String COLUMN_RULE_SOURCE_WORKBOOK_ID = "sourceWBId";   //workbooks table
    public static final String COLUMN_RULE_SOURCE_WORKBOOK_NAME = "sourceWBName";   //workbooks table
    public static final String COLUMN_RULE_SOURCE_WORKBOOK_DIR = "sourceWBDir";  //workbooks table
    public static final String COLUMN_RULE_SOURCE_WORKBOOK_SHEET = "sourceWBSheet";   //source sheet name --> workbooks table: COLUMN_WORKBOOK_SHEET_NAMES = "sheetNames";
    public static final String COLUMN_RULE_SOURCE_SHEET_PROJECT_NAME = "sourceProjName";    //source: Project Name --> sheets table: COLUMN_SHEET_Y_HEADER_NAMES = "headerYNames";
    public static final String COLUMN_RULE_SOURCE_SHEET_PROJECT_NUMBER = "sourceProjNumber";   //IE:source: Project Number --> sheets table: COLUMN_SHEET_X_HEADER_NAMES = "headerXNames";
    public static final String COLUMN_RULE_DEST_WORKBOOK_ID = "destWBId";  //workbooks table
    public static final String COLUMN_RULE_DEST_WORKBOOK_NAME = "destWBName";  //workbooks table
    public static final String COLUMN_RULE_DEST_WORKBOOK_DIR = "destWBDir";  //workbooks table
    public static final String COLUMN_RULE_DEST_WORKBOOK_SHEET = "destWBSheet";   //dest sheet name --> workbooks table
    public static final String COLUMN_RULE_DEST_SHEET_PROJECT_NAME = "destProjName";    //Destination: Project Name --> sheets table
    public static final String COLUMN_RULE_DEST_SHEET_PROJECT_NUMBER = "destProjNumber";   //Destination: Project Number --> sheets table

    public static final int INDEX_RULE_ID = 1;
    public static final int INDEX_RULE_NAME = 2;
    public static final int INDEX_RULE_SOURCE_WORKBOOK_ID = 3;   //workbooks table
    public static final int INDEX_RULE_SOURCE_WORKBOOK_NAME = 4;   //workbooks table
    public static final int INDEX_RULE_SOURCE_WORKBOOK_DIR = 5;  //workbooks table
    public static final int INDEX_RULE_SOURCE_WORKBOOK_SHEET = 6;   //source sheet name --> workbooks table: COLUMN_WORKBOOK_SHEET_NAMES = "sheetNames";
    public static final int INDEX_RULE_SOURCE_SHEET_PROJECT_NAME = 7;    //source: Project Name --> sheets table: COLUMN_SHEET_Y_HEADER_NAMES = "headerYNames";
    public static final int INDEX_RULE_SOURCE_SHEET_PROJECT_NUMBER = 8;   //IE:source: Project Number --> sheets table: COLUMN_SHEET_X_HEADER_NAMES = "headerXNames";
    public static final int INDEX_RULE_DEST_WORKBOOK_ID = 9;  //workbooks table
    public static final int INDEX_RULE_DEST_WORKBOOK_NAME = 10;  //workbooks table
    public static final int INDEX_RULE_DEST_WORKBOOK_DIR = 11;  //workbooks table
    public static final int INDEX_RULE_DEST_WORKBOOK_SHEET = 12;   //dest sheet name --> workbooks table
    public static final int INDEX_RULE_DEST_SHEET_PROJECT_NAME = 13;    //Destination: Project Name --> sheets table
    public static final int INDEX_RULE_DEST_SHEET_PROJECT_NUMBER = 14;   //Destination: Project Number --> sheets table

    //*************** SUCCESS TABLE VARS:
    public static final String TABLE_SUCCESS = "success";
    public static final String COLUMN_SUCCESS_ID = "_id";
    public static final String COLUMN_SUCCESS_DATE = "date";
    public static final String COLUMN_SUCCESS_RULE_ID = "ruleId";   //rule table
    public static final String COLUMN_SUCCESS_RULE_NAME = "ruleName";   //rule name

    public static final int INDEX_SUCCESS_ID = 1;
    public static final int INDEX_SUCCESS_DATE = 2;
    public static final int INDEX_SUCCESS_RULE_ID = 3;   //rule table --> _id
    public static final int INDEX_SUCCESS_RULE_NAME = 4;   //rule table -->rule name

    //*************** FAIL TABLE VARS:
    public static final String TABLE_FAIL = "fail";
    public static final String COLUMN_FAIL_ID = "_id";
    public static final String COLUMN_FAIL_DATE = "date";
    public static final String COLUMN_FAIL_RULE_ID = "ruleId";   //rule table
    public static final String COLUMN_FAIL_RULE_NAME = "ruleName";   //rule name

    public static final int INDEX_FAIL_ID = 1;
    public static final int INDEX_FAIL_DATE = 2;
    public static final int INDEX_FAIL_RULE_ID = 3;   //rule table --> _id
    public static final int INDEX_FAIL_RULE_NAME = 4;   //rule table -->rule name

    //*************** ORDERING VARS:
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;


    //**************** QUERIES:
    public static final String QUERY_OWNER = "SELECT " + COLUMN_OWNER_ID + " FROM " +
            TABLE_OWNERS + " WHERE " + COLUMN_OWNER_NAME + " = ?";

    /*public static final String INSERT_OWNER = "INSERT INTO " + TABLE_OWNERS +
            '(' + COLUMN_OWNER_NAME + ") VALUES(?)";*/

    public static final String INSERT_OWNER = "INSERT INTO " + TABLE_OWNERS +
            '(' + COLUMN_OWNER_NAME + ", " + COLUMN_OWNER_ID + ") VALUES(?, ?)";


    //COUNT used here, counts the number of rows in a table:
    public static final String EMPTY_OWNER_TABLE_QUERY = "SELECT COUNT(*) FROM " + TABLE_OWNERS;

    private Connection conn;
    private PreparedStatement insertIntoOwnersPS;
    private PreparedStatement queryOwnerPS;
    private PreparedStatement emptyOwnerTableQueryPS;

    //SINGLETON INSTANCE
    //Variable that holds the one and only singleton instance --> lazy instantiation
    private static Datasource instance = new Datasource();

    //CONSTRUCTOR:
   /* public Datasource() {   //Constructor

    }
*/
    public static Datasource getInstance() {    //Method that allows other classes access to the db/singleton instance
        return instance;
    }


    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);  //Creates db IF not one created already
            Statement statement = conn.createStatement();

           // statement.execute("DROP TABLE IF EXISTS " + TABLE_OWNERS);  //DELETES TABLE

            //create table entries (id integer primary key, data)
            //Original: " (" + COLUMN_OWNER_ID + " integer, " +
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_OWNERS +
                    " (" + COLUMN_OWNER_ID + " integer primary key, " +
                    COLUMN_OWNER_NAME + " text" + ")");

            //Prepared Statements:
            insertIntoOwnersPS = conn.prepareStatement(INSERT_OWNER, Statement.RETURN_GENERATED_KEYS);
            queryOwnerPS = conn.prepareStatement(QUERY_OWNER);
            emptyOwnerTableQueryPS = conn.prepareStatement(EMPTY_OWNER_TABLE_QUERY);

            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(insertIntoOwnersPS != null) {
                insertIntoOwnersPS.close();
            }

            if(queryOwnerPS != null) {
                queryOwnerPS.close();
            }

            if(emptyOwnerTableQueryPS != null){
                emptyOwnerTableQueryPS.close();
            }

            //CANNOT CLOSE CONNECTION BEFORE queries, order is important
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


    public List<Owner> queryOwner(int sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_OWNERS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_OWNER_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Owner> owners = new ArrayList<>();
            while (results.next()) {
                Owner owner = new Owner();
                owner.setId(results.getInt(INDEX_OWNER_ID));
                owner.setName(results.getString(INDEX_OWNER_NAME));
                owners.add(owner);
            }

            return owners;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } catch (NullPointerException e) {
            System.out.println("Datasource.queryOwner -->Empty table/database " + e.getMessage() );
            return null;
        }
    }
    //TABLE_OWNERS - "owners"
    public int EmptyTableQuery(String table) {
        int count = 0;
        //#1if
        if(table.equals(TABLE_OWNERS)) {
            try{
                ResultSet results = emptyOwnerTableQueryPS.executeQuery();
                if(results.next()) {
                    count = results.getInt(1);
                    if(count == 0) { count = -1; }
                }
            } catch (SQLException e) {
                System.err.println("Datasource-->EmptyTableQuery--> #1if " + e.getMessage());
                return -1;
            }

        }
      return count;
    }

/*
public static final String QUERY_OWNER = "SELECT " + COLUMN_OWNER_ID + " FROM " +
            TABLE_OWNERS + " WHERE " + COLUMN_OWNER_NAME + " = ?";

    public static final String INSERT_OWNER = "INSERT INTO " + TABLE_OWNERS +
            '(' + COLUMN_OWNER_NAME + ") VALUES(?)";

 */

    /*
     //Module 379: Insert Albums, Artists, and Songs
    public void insertSong(String title, String artist, String album, int track) {

        try {
            conn.setAutoCommit(false);

            int artistId = insertArtist(artist);  //if artist already exists ID is returned, if not we get one back
            int albumId = insertAlbum(album, artistId);  //same as above
            insertIntoSongs.setInt(1, track);     //Code that is adding var to string
            insertIntoSongs.setString(2, title);
//ROLLBACK TEST            insertIntoSongs.setInt(8, albumId);  //*ArrayIndexOutOfBoundException
            insertIntoSongs.setInt(3, albumId);  //CORRECT
            int affectedRows = insertIntoSongs.executeUpdate();
            if(affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException("The song insert failed");
            }

        } catch(Exception e) { //*Replace with Exception e
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch(SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }
    }


     */

    //cases:
    //1. returns owner id, 2. no owner id exists (-4 returned)
    public int getOwnerId(String name){

        try {
            queryOwnerPS.setString(1, name);
            ResultSet results = queryOwnerPS.executeQuery();
            if (results.next()) {
                return results.getInt(1);
            }
        } catch (SQLException e) {
           System.err.println("Datasource --> getOwnerId --> " + e.getMessage());
        }
    return -2;  //First owner key is , return -2 if no record for owner
}

        //System.out.println(results.getRow());
        //System.out.println(results.getRowId(1));
    public int insertOwner(String name) throws SQLException {
           int result = -1;

           try {
                conn.setAutoCommit(false);
                insertIntoOwnersPS.setString(1, name);  //Parameter Index 1 --> add name to new record
                ResultSet generatedKeys = insertIntoOwnersPS.getGeneratedKeys();

                if(generatedKeys.next()) {
                    result = generatedKeys.getInt(1);  //0
                    result = generatedKeys.getRow();  //1
           } else {
               throw new SQLException("Couldn't load/get _id for owner");
           }

           int affectedRows = insertIntoOwnersPS.executeUpdate();
           if(affectedRows == 1) {
              conn.commit();
           } else {
             throw new SQLException("The owner insert failed");
           }
        } catch(Exception e) { //*Replace with Exception e
              System.out.println("Insert owner exception: " + e.getMessage());
              try {
                     System.out.println("Performing rollback");
                     conn.rollback();
              } catch(SQLException e2) {
                     System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
              }
       } finally {
              try {
                     System.out.println("Resetting default commit behavior");
                     conn.setAutoCommit(true);
              } catch(SQLException e) {
                     System.out.println("Couldn't reset auto-commit! " + e.getMessage());
              }
      }
    return result;
    }


}  //END Datasource
