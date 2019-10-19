package com.kurguzov.Utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.*;

import java.util.HashMap;
import java.util.Map;

public class XMLParser {
    private static Map<String,String> pairXMLMap = new HashMap<>();
    private final static File xmlFile = new File("src/main/resources/databaseH2Config.xml");
    static {
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            if(doc.getDocumentElement().getNodeName().equals("database-configuration")){
                NodeList nodeList = doc.getElementsByTagName("database-configuration");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        pairXMLMap.put("database-url",element.getElementsByTagName("database-url").item(0).getTextContent());
                        pairXMLMap.put("database-username",element.getElementsByTagName("database-username").item(0).getTextContent());
                        pairXMLMap.put("database-password",element.getElementsByTagName("database-password").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected static Map<String,String> getPairXMLMap(){
        return pairXMLMap;
    }

}


