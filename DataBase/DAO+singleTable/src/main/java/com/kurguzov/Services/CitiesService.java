package com.kurguzov.Services;

import com.kurguzov.DAO.CitiesDAO;
import com.kurguzov.Entities.CitiesEntity;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Utils.Util;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesService implements CitiesDAO {

    @Override
    public void add(CitiesEntity city) throws SQLException,ClassNotFoundException, SAXException, IOException, ParserConfigurationException {
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO CITIES(CITY_ID,CITY_NAME) VALUES" +
                " ("+city.getCity_id()+",\'"+city.getCity_name()+"\')";
        statement.execute(sql);
        connection.close();
    }

    @Override
    public CitiesEntity getById(int id) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        CitiesEntity citiesEntity = new CitiesEntity();
        String sql = "SELECT * FROM CITIES WHERE CITY_ID = " + id;
        Connection connection = Util.getConnection();
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            if (resultSet.getInt("city_id") == id){
                citiesEntity.setCity_id(resultSet.getInt("city_id"));
                citiesEntity.setCity_name(resultSet.getString("city_name"));
            }
        }
        connection.close();
        return citiesEntity;
    }

    @Override
    public void update(CitiesEntity city) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        String sql = "UPDATE CITIES SET city_name=\'"+city.getCity_name()+"\' WHERE city_id=" + city.getCity_id();
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        String sql = "DELETE FROM CITIES WHERE city_id=" + id;
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }

    @Override
    public List<CitiesEntity> getAll() throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        String sql = "SELECT * FROM CITIES";
        List<CitiesEntity> citiesEntityList = new ArrayList<>();
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            CitiesEntity citiesEntity = new CitiesEntity();
            citiesEntity.setCity_id(resultSet.getInt("city_id"));
            citiesEntity.setCity_name(resultSet.getString("city_name"));
            citiesEntityList.add(citiesEntity);
        }
        connection.close();
        return citiesEntityList;
    }
}
