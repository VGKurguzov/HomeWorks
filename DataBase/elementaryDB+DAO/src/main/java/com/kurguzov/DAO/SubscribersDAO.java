package com.kurguzov.DAO;

import com.kurguzov.Entities.SubscribersEntity;
import java.util.List;

public interface SubscribersDAO {
    void add(SubscribersEntity sub);
    SubscribersEntity getById(int id);
    void update(SubscribersEntity sub);
    void delete(int id);
    List<SubscribersEntity> getAll();
}