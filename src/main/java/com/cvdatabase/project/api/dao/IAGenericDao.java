package com.cvdatabase.project.api.dao;

import com.cvdatabase.project.entities.AEntity;

import java.util.List;

public interface IAGenericDao<T extends AEntity> {

    Class<T> getGenericClass();

    T create(T entity);

    T get(Integer id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();

}
