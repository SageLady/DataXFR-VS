package datamodel;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatasourceOwner {

    public static final String DB_NAME_OWNERS = "owners.db";
    public static final String SEPARATOR =  File.separator;
    public static final String TABLE_OWNERS = "owners";
    public static final String COLUMN_OWNER_ID = "_id";
    public static final String COLUMN_OWNER_NAME = "name";
    public static final int INDEX_OWNER_ID = 1;
    public static final int INDEX_OWNER_NAME = 2;
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    //    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;
    //    public static final String CONNECTION_STRING = "jdbc:sqlite:/Volumes/Production/Courses/Programs/JavaPrograms/Music/" + DB_NAME;
    public static final String CONNECTION_STRING =
            "jdbc:sqlite:C:" + SEPARATOR + "Users" + SEPARATOR  + "19255" + SEPARATOR  +
                    "IdeaProjects" + SEPARATOR  + "DataXFR-VS" + SEPARATOR  + DB_NAME_OWNERS;


    public static final String QUERY_OWNER = "SELECT " + COLUMN_OWNER_ID + " FROM " +
            TABLE_OWNERS + " WHERE " + COLUMN_OWNER_NAME + " = ?";

    private Connection conn;

    private PreparedStatement queryOwner;



    //SINGLETON INSTANCE
    //Variable that holds the one and only singleton instance --> lazy instantiation
    private static DatasourceOwner instance = new DatasourceOwner();


    //CONSTRUCTOR:
    private DatasourceOwner() {   //Constructor

    }

    public static DatasourceOwner getInstance() {    //Method that allows other classes access to the db/singleton instance
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            queryOwner = conn.prepareStatement(QUERY_OWNER);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(queryOwner != null) {
                queryOwner.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


    public List<Owner> queryArtists(int sortOrder) {

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
                //Module 385 -added try catch to see progress bar
                try {
                    Thread.sleep(20);

                } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + e.getMessage());

                }


                Owner owner = new Owner();  //Mod383: Creating artist object via constructor in class
                owner.setId(results.getInt(INDEX_OWNER_ID));
                owner.setName(results.getString(INDEX_OWNER_NAME));
                owners.add(owner);
            }

            return owners;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }




} //END DatasourceOwner
