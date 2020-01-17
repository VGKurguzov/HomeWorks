package com.kurguzov.Utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {
//    private static Map<String,String> pairXMLMap = new HashMap<>();
//    private final static File XMLFILE = new File("src/main/resources/databaseConfig.xml");
////    private static boolean initialization = false;
//
//    protected static void init() throws SAXException, IOException, ParserConfigurationException {
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document doc = documentBuilder.parse(XMLFILE);
//            doc.getDocumentElement().normalize();
//
//            if(doc.getDocumentElement().getNodeName().equals("database-configuration")){
//                NodeList nodeList = doc.getElementsByTagName("database-configuration");
//                for (int i = 0; i < nodeList.getLength(); i++) {
//                    Node node = nodeList.item(i);
//                    if (node.getNodeType() == Node.ELEMENT_NODE) {
//                        Element element = (Element) node;
//                        pairXMLMap.put("database-url",element.getElementsByTagName("database-url").item(0).getTextContent());
//                        pairXMLMap.put("database-username",element.getElementsByTagName("database-username").item(0).getTextContent());
//                        pairXMLMap.put("database-password",element.getElementsByTagName("database-password").item(0).getTextContent());
//                    }
//                }
//            }
//    }
//    protected static Map<String,String> getPairXMLMap(){
//        return pairXMLMap;
//    }



    private final static File XMLFILE = new File("src/main/resources/databaseConfig.xml");
    private static Map<String,String> pairXMLMap = null;

    private XMLParser(){}

    public static void init() throws SAXException, IOException, ParserConfigurationException {
        if(pairXMLMap == null){
            pairXMLMap = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(XMLFILE);
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
        }
    }

    static Map<String,String> getPairXMLMap(){
        return pairXMLMap;
    }

}



