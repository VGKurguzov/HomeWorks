package com.kurguzov.DAO;

import com.kurguzov.Entities.SubscribersEntity;
import java.sql.SQLException;
import java.util.List;

public interface SubscribersDAO {
    void add(SubscribersEntity sub)throws SQLException,ClassNotFoundException;
    SubscribersEntity getById(int id)throws SQLException,ClassNotFoundException;
    void update(SubscribersEntity sub)throws SQLException,ClassNotFoundException;
    void delete(int id)throws SQLException,ClassNotFoundException;
    List<SubscribersEntity> getAll()throws SQLException,ClassNotFoundException;
}