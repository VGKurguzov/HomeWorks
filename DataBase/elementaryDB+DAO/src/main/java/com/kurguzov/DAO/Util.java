package com.kurguzov.DAO;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(getArgParam(0));
            connection = DriverManager.getConnection(getArgParam(1),getArgParam(2),getArgParam(3));
            System.out.println("Connection is SUCCESS!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection is FAILED!");
            e.printStackTrace();
        }
        return connection;
    }
    private String getArgParam(int indexArg){
        List<String> param = new ArrayList<>();
        {
            boolean isvalid = false;
            final String fileName = new File("src/main/resources/databaseConfig.xml").getAbsolutePath();
            try {
                XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
                while (xmlr.hasNext()) {
                    xmlr.next();
                    if(xmlr.isStartElement() && xmlr.getLocalName() == "database-configuration"){
                        isvalid = true;
                    }
                    if(isvalid && xmlr.getLocalName() == "database-driver"){
                        param.add(0,xmlr.getText());
                    }
                    if(isvalid && xmlr.getLocalName() == "database-url"){
                        param.add(1,xmlr.getText());
                    }
                    if(isvalid && xmlr.getLocalName() == "database-username"){
                        param.add(2,xmlr.getText());
                    }
                    if(isvalid && xmlr.getLocalName() == "database-password"){
                        param.add(3,xmlr.getText());
                    }
                    if(xmlr.isEndElement() && xmlr.getLocalName() == "/database-configuration"){
                        isvalid = false;
                    }
                }
            } catch (XMLStreamException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return param.get(indexArg);
    }
}
