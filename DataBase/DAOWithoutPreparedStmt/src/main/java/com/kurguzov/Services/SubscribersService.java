package com.kurguzov.Services;

import com.kurguzov.DAO.SubscribersDAO;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Utils.Util;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersService implements SubscribersDAO {

    @Override
    public void add(SubscribersEntity sub) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO SUBSCRIBERS_PRIMITIVE(SUB_ID,SUB_FIO,SUB_CITY,SUB_TARIFF,SUB_PRICE) VALUES" +
                " ("+sub.getSub_id()+",\'"+sub.getSub_fio()+"\',\'"+sub.getSub_city()+"\',\'"+sub.getSub_tariff()+"\',"+sub.getSub_price()+")";
        statement.execute(sql);
        connection.close();
    }

    @Override
    public SubscribersEntity getById(int id) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        Connection connection = Util.getConnection();
        String sql = "SELECT * FROM SUBSCRIBERS_PRIMITIVE WHERE SUB_ID = "+id;
        SubscribersEntity subscribersEntity = new SubscribersEntity();
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            if (resultSet.getInt("sub_id") == id){
                subscribersEntity.setSub_id(resultSet.getInt("sub_id"));
                subscribersEntity.setSub_fio(resultSet.getString("sub_fio"));
                subscribersEntity.setSub_city(resultSet.getString("sub_city"));
                subscribersEntity.setSub_tariff(resultSet.getString("sub_tariff"));
                subscribersEntity.setSub_price(resultSet.getInt("sub_price"));
            }
        }
        connection.close();
        return subscribersEntity;
    }

    @Override
    public void update(SubscribersEntity sub) throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        Connection connection = Util.getConnection();
        String sql = "UPDATE SUBSCRIBERS_PRIMITIVE SET sub_fio=\'" + sub.getSub_fio() + "\',sub_city=\'"+sub.getSub_city()+"\', " +
                "sub_tariff= \'"+sub.getSub_tariff()+"\',sub_price="+sub.getSub_price()+" WHERE sub_id="+sub.getSub_id();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException,ClassNotFoundException, SAXException, IOException, ParserConfigurationException {
        Connection connection = Util.getConnection();
        String sql = "DELETE FROM SUBSCRIBERS_PRIMITIVE WHERE sub_id=" + id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }

    @Override
    public List<SubscribersEntity> getAll() throws SQLException,ClassNotFoundException,SAXException,IOException,ParserConfigurationException {
        Connection connection = Util.getConnection();
        String sql = "SELECT * FROM SUBSCRIBERS_PRIMITIVE";
        List<SubscribersEntity> subscribersEntityList = new ArrayList<>();
       Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            SubscribersEntity sub = new SubscribersEntity();
            sub.setSub_id(resultSet.getInt("sub_id"));
            sub.setSub_fio(resultSet.getString("sub_fio"));
            sub.setSub_city(resultSet.getString("sub_city"));
            sub.setSub_tariff(resultSet.getString("sub_tariff"));
            sub.setSub_price(resultSet.getInt("sub_price"));
            subscribersEntityList.add(sub);
        }
        connection.close();
        return subscribersEntityList;
    }
}
