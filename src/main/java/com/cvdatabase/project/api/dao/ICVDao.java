package com.cvdatabase.project.api.dao;

import com.cvdatabase.project.entities.CV;

import java.util.List;

public interface ICVDao extends IAGenericDao<CV> {

    List<CV> getCVByTechnologyName(String name);

    List<CV> getCVByPersonFirstName(String firstName);

    List<CV> getCVByPersonLastName(String lastName);

    List<CV> getCVByPersonFullName(String firstName, String lastName);

}
