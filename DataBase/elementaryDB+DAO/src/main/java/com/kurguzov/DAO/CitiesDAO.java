package com.kurguzov.DAO;

import com.kurguzov.Entities.CitiesEntity;

import java.sql.SQLException;
import java.util.List;

public interface CitiesDAO {
    void add(CitiesEntity city)throws SQLException,ClassNotFoundException;
    CitiesEntity getById(int id)throws SQLException,ClassNotFoundException;
    void update(CitiesEntity city)throws SQLException,ClassNotFoundException;
    void delete(int id)throws SQLException,ClassNotFoundException;
    List<CitiesEntity> getAll()throws SQLException,ClassNotFoundException;
}