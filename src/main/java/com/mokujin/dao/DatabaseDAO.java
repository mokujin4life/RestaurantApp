package com.mokujin.dao;

import java.util.List;

public interface DatabaseDAO<T> {
    List<T> getAll();

    T get(Integer id);

    void add(T t);

    void delete(T t);

    void edit(T t);
}
