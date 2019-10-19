package com.kurguzov.Service;

import com.kurguzov.DAO.SubscribersDAO;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribersService extends Util implements SubscribersDAO {

    @Override
    public void add(SubscribersEntity sub) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SUBSCRIBERS(SUB_ID,SUB_FIO,SUB_CITY_ID,SUB_TARIFF,SUB_PRICE) VALUES (?,?,?,?,?)";

        try(Connection connection = Util.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,sub.getSub_id());
            preparedStatement.setString(2,sub.getSub_fio());
            preparedStatement.setInt(3,sub.getSub_city_id());
            preparedStatement.setString(4,sub.getSub_tariff());
            preparedStatement.setInt(5,sub.getSub_price());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public SubscribersEntity getById(int id) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM SUBSCRIBERS WHERE ID = ?";
        SubscribersEntity subscribersEntity = new SubscribersEntity();

        try(Connection connection = Util.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            subscribersEntity.setSub_id(resultSet.getInt("sub_id"));
            subscribersEntity.setSub_fio(resultSet.getString("sub_fio"));
            subscribersEntity.setSub_city_id(resultSet.getInt("sub_city_id"));
            subscribersEntity.setSub_tariff(resultSet.getString("sub_tariff"));
            subscribersEntity.setSub_price(resultSet.getInt("sub_price"));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return subscribersEntity;
    }

    @Override
    public void update(SubscribersEntity sub) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE SUBSCRIBERS SET sub_fio=?,sub_city_id=?,sub_tariff=?,sub_price=? WHERE sub_id=?";

        try(Connection connection = Util.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(5,sub.getSub_id());
            preparedStatement.setString(1,sub.getSub_fio());
            preparedStatement.setInt(2,sub.getSub_city_id());
            preparedStatement.setString(3,sub.getSub_tariff());
            preparedStatement.setInt(4,sub.getSub_price());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM SUBSCRIBERS WHERE sub_id=?";

        try(Connection connection = Util.getConnection()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<SubscribersEntity> getAll() {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM SUBSCRIBERS";
        List<SubscribersEntity> subscribersEntityList = new ArrayList<>();

        try(Connection connection = Util.getConnection()){
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return subscribersEntityList;
    }

}
