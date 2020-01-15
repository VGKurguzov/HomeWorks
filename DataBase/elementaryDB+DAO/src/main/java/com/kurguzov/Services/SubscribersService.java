package com.kurguzov.Services;

import com.kurguzov.DAO.SubscribersDAO;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Utils.Util;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribersService implements SubscribersDAO {

    @Override
    public void add(SubscribersEntity sub) throws SQLException,ClassNotFoundException, SAXException, IOException, ParserConfigurationException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SUBSCRIBERS(SUB_ID,SUB_FIO,SUB_CITY_ID,SUB_TARIFF,SUB_PRICE) VALUES (?,?,?,?,?)";
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,sub.getSub_id());
        preparedStatement.setString(2,sub.getSub_fio());
        preparedStatement.setInt(3,sub.getSub_city_id());
        preparedStatement.setString(4,sub.getSub_tariff());
        preparedStatement.setInt(5,sub.getSub_price());
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public SubscribersEntity getById(int id) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM SUBSCRIBERS WHERE SUB_ID = ?";
        SubscribersEntity subscribersEntity = new SubscribersEntity();
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getInt("sub_id") == id){
                subscribersEntity.setSub_id(resultSet.getInt("sub_id"));
                subscribersEntity.setSub_fio(resultSet.getString("sub_fio"));
                subscribersEntity.setSub_city_id(resultSet.getInt("sub_city_id"));
                subscribersEntity.setSub_tariff(resultSet.getString("sub_tariff"));
                subscribersEntity.setSub_price(resultSet.getInt("sub_price"));
            }
        }
        connection.close();
        return subscribersEntity;
    }

    @Override
    public void update(SubscribersEntity sub) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE SUBSCRIBERS SET sub_fio=?,sub_city_id=?,sub_tariff=?,sub_price=? WHERE sub_id=?";
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(5,sub.getSub_id());
        preparedStatement.setString(1,sub.getSub_fio());
        preparedStatement.setInt(2,sub.getSub_city_id());
        preparedStatement.setString(3,sub.getSub_tariff());
        preparedStatement.setInt(4,sub.getSub_price());
        preparedStatement.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM SUBSCRIBERS WHERE sub_id=?";
        Connection connection = Util.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
    }

    @Override
    public List<SubscribersEntity> getAll() throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM SUBSCRIBERS";
        List<SubscribersEntity> subscribersEntityList = new ArrayList<>();
        Connection connection = Util.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            SubscribersEntity sub = new SubscribersEntity();
            sub.setSub_id(resultSet.getInt("sub_id"));
            sub.setSub_fio(resultSet.getString("sub_fio"));
            sub.setSub_city_id(resultSet.getInt("sub_city_id"));
            sub.setSub_tariff(resultSet.getString("sub_tariff"));
            sub.setSub_price(resultSet.getInt("sub_price"));
            subscribersEntityList.add(sub);
        }
        connection.close();
        return subscribersEntityList;
    }
}
