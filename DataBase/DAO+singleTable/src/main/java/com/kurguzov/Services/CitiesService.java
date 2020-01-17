package com.kurguzov.Services;

import com.kurguzov.DAO.CitiesDAO;
import com.kurguzov.Entities.CitiesEntity;
import com.kurguzov.Utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesService implements CitiesDAO {

    @Override
    public void add(CitiesEntity city) throws SQLException,ClassNotFoundException {
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO CITIES(CITY_ID,CITY_NAME) VALUES" +
                " ("+city.getCityId()+",\'"+city.getCityName()+"\')";
        statement.execute(sql);
    }

    @Override
    public CitiesEntity getById(int id) throws SQLException,ClassNotFoundException {
        CitiesEntity citiesEntity = new CitiesEntity();
        String sql = "SELECT * FROM CITIES WHERE CITY_ID = " + id;
        Connection connection = ConnectionDB.getConnection();
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            if (resultSet.getInt("city_id") == id){
                citiesEntity.setCityId(resultSet.getInt("city_id"));
                citiesEntity.setCityName(resultSet.getString("city_name"));
            }
        }
        return citiesEntity;
    }

    @Override
    public void update(CitiesEntity city) throws SQLException,ClassNotFoundException {
        String sql = "UPDATE CITIES SET city_name=\'"+city.getCityName()+"\' WHERE city_id=" + city.getCityId();
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    @Override
    public void delete(int id) throws SQLException,ClassNotFoundException {
        String sql = "DELETE FROM CITIES WHERE city_id=" + id;
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public List<CitiesEntity> getAll() throws SQLException,ClassNotFoundException {
        String sql = "SELECT * FROM CITIES";
        List<CitiesEntity> citiesEntityList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            CitiesEntity citiesEntity = new CitiesEntity();
            citiesEntity.setCityId(resultSet.getInt("city_id"));
            citiesEntity.setCityName(resultSet.getString("city_name"));
            citiesEntityList.add(citiesEntity);
        }
        return citiesEntityList;
    }
}
