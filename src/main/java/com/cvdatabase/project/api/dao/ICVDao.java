package com.cvdatabase.project.api.dao;

import com.cvdatabase.project.entities.CV;

import java.util.List;

public interface ICVDao extends IAGenericDao<CV> {

    List<CV> getByTechnologyName(String name);

    List<CV> getByFirstName(String firstName);

    List<CV> getByLastName(String lastName);

}
