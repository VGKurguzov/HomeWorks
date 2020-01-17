package com.kurguzov.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB{
    private static Connection connection = null;

    private ConnectionDB(){
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(XMLParser.getPairXMLMap().get("database-url"),
            XMLParser.getPairXMLMap().get("database-username"),
            XMLParser.getPairXMLMap().get("database-password"));
        }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        connection.close();
    }

}