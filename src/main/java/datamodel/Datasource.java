package datamodel;

import java.io.File;

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
    public final int ORDER_BY_NONE = 1;
    public final int ORDER_BY_ASC = 2;
    public final int ORDER_BY_DESC = 3;


}
