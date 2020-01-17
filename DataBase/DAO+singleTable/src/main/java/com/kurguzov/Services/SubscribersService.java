package com.kurguzov.Services;

import com.kurguzov.DAO.SubscribersDAO;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersService implements SubscribersDAO {

    @Override
    public void add(SubscribersEntity sub) throws SQLException,ClassNotFoundException {
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO SUBSCRIBERS(SUB_ID,SUB_FIO,SUB_CITY_ID,SUB_TARIFF,SUB_PRICE) VALUES" +
                " ("+sub.getSubId()+",\'"+sub.getSubFio()+"\',\'"+sub.getSubCityId()+"\',\'"+sub.getSubTariff()+"\',"+sub.getSubPrice()+")";
        statement.execute(sql);
    }

    @Override
    public SubscribersEntity getById(int id) throws SQLException,ClassNotFoundException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM SUBSCRIBERS WHERE SUB_ID = "+id;
        SubscribersEntity subscribersEntity = new SubscribersEntity();
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            if (resultSet.getInt("sub_id") == id){
                subscribersEntity.setSubId(resultSet.getInt("sub_id"));
                subscribersEntity.setSubFio(resultSet.getString("sub_fio"));
                subscribersEntity.setSubCityId(resultSet.getInt("sub_city_id"));
                subscribersEntity.setSubTariff(resultSet.getString("sub_tariff"));
                subscribersEntity.setSubPrice(resultSet.getInt("sub_price"));
            }
        }
        return subscribersEntity;
    }

    @Override
    public void update(SubscribersEntity sub) throws SQLException,ClassNotFoundException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "UPDATE SUBSCRIBERS SET sub_fio=\'" + sub.getSubFio() + "\',sub_city_id=\'"+sub.getSubCityId()+"\', " +
                "sub_tariff= \'"+sub.getSubTariff()+"\',sub_price="+sub.getSubPrice()+" WHERE sub_id="+sub.getSubId();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    @Override
    public void delete(int id) throws SQLException,ClassNotFoundException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM SUBSCRIBERS WHERE sub_id=" + id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public List<SubscribersEntity> getAll() throws SQLException,ClassNotFoundException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT * FROM SUBSCRIBERS";
        List<SubscribersEntity> subscribersEntityList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            SubscribersEntity sub = new SubscribersEntity();
            sub.setSubId(resultSet.getInt("sub_id"));
            sub.setSubFio(resultSet.getString("sub_fio"));
            sub.setSubCityId(resultSet.getInt("sub_city_id"));
            sub.setSubTariff(resultSet.getString("sub_tariff"));
            sub.setSubPrice(resultSet.getInt("sub_price"));
            subscribersEntityList.add(sub);
        }
        return subscribersEntityList;
    }
}
