package com.cvdatabase.project.api.dao;

import com.cvdatabase.project.entities.Person;

import java.util.List;

public interface IPersonDao extends IAGenericDao<Person> {

    List<Person> getByFirstName(String firstName);

    List<Person> getByLastName(String lastName);

    List<Person> getByFullName(String firstName, String lastName);

}
