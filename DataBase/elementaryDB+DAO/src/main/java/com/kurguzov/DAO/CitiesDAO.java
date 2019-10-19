package com.kurguzov.DAO;

import com.kurguzov.Entities.CitiesEntity;
import java.util.List;

public interface CitiesDAO {
    void add(CitiesEntity city);
    CitiesEntity getById(int id);
    void update(CitiesEntity city);
    void delete(int id);
    List<CitiesEntity> getAll();
}