package com.mokujin.dao;

import java.util.List;

public interface DatabaseDAO<T> {
    List<T> getAll();

    T get(int id);

    void add(T t);

    void delete(Integer id);

    void edit(T t);
}
