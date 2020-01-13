package com.kurguzov.Services;

import com.kurguzov.DAO.CitiesDAO;
import com.kurguzov.Entities.CitiesEntity;
import com.kurguzov.Utils.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesService extends Util implements CitiesDAO {

    @Override
    public void add(CitiesEntity city) throws SQLException,ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Cities(city_id,city_name) VALUES (?,?)";
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,city.getCity_id());
        preparedStatement.setString(2,city.getCity_name());
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public CitiesEntity getById(int id) throws SQLException,ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM CITIES WHERE CITY_ID = ?";
        CitiesEntity citiesEntity = new CitiesEntity();
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getInt("city_id") == id){
                citiesEntity.setCity_id(resultSet.getInt("city_id"));
                citiesEntity.setCity_name(resultSet.getString("city_name"));
            }
        }
        return citiesEntity;
    }

    @Override
    public void update(CitiesEntity city) throws SQLException,ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CITIES SET city_name=? WHERE city_id=?";
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,city.getCity_name());
        preparedStatement.setInt(2,city.getCity_id());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException,ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM CITIES WHERE city_id=?";
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<CitiesEntity> getAll() throws SQLException,ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM CITIES";
        List<CitiesEntity> citiesEntityList = new ArrayList<>();
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            CitiesEntity citiesEntity = new CitiesEntity();
            citiesEntity.setCity_id(resultSet.getInt("city_id"));
            citiesEntity.setCity_name(resultSet.getString("city_name"));
            citiesEntityList.add(citiesEntity);
        }
        return citiesEntityList;
    }
}
