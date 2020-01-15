package com.kurguzov.DAO;

import com.kurguzov.Entities.SubscribersEntity;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface SubscribersDAO {
    void add(SubscribersEntity sub)throws SQLException,ClassNotFoundException, SAXException, IOException, ParserConfigurationException;
    SubscribersEntity getById(int id)throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException;
    void update(SubscribersEntity sub)throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException;
    void delete(int id)throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException;
    List<SubscribersEntity> getAll()throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException;
}