package com.cvdatabase.project.api.dao;

import com.cvdatabase.project.entities.Technology;

import java.util.List;

public interface ITechnologyDao extends IAGenericDao<Technology> {

    public Technology getByName(String name);
}
