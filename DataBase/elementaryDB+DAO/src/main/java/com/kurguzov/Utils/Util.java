package com.kurguzov.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util extends XMLParser {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(XMLParser.getPairXMLMap().get("database-url"),
                    XMLParser.getPairXMLMap().get("database-username"),
                    XMLParser.getPairXMLMap().get("database-password"));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection is FAILED!");
            e.printStackTrace();
        }
        return connection;
    }

}
