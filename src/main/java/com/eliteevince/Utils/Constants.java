package com.eliteevince.Utils;

/**
 *
 * @author Meet
 */
public class Constants {

    public enum PropsName {
        PROTOCOL, HOST, PORT, URL, DB, USERNAME, PASSWORD;
    }

    public static final String PROTOCOL = "http";
    public static final String HOST = "localhost";
    public static final String PORT = "8069";
    public static final String URL = PROTOCOL + "://" + HOST + ":" + PORT;
    public static final String DB = "";
    public static final String USERNAME = "";
    public static final String PASSWORD = "";
    
    
    public static final String COMMON_URL = "/xmlrpc/2/common";
    public static final String OBJECT_URL = "/xmlrpc/2/object";
    public static final String REPORT_URL = "/xmlrpc/2/report";
    public static final String DATABASE_URL = "/xmlrpc/2/db";
}
