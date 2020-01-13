package com.kurguzov.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util extends XMLParser {
    private static Connection connection = null;
    public static Connection getConnection() throws ClassNotFoundException,SQLException{
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection(XMLParser.getPairXMLMap().get("database-url"),
        XMLParser.getPairXMLMap().get("database-username"),
        XMLParser.getPairXMLMap().get("database-password"));
        return connection;
    }
}
