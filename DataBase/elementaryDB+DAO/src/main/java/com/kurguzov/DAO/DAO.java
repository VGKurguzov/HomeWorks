package com.kurguzov.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    public void insert(T obj);
    public T getById(int id);
    public void update(T obj);
    public void delete(T obj);
    public ArrayList<T> getAll();
}