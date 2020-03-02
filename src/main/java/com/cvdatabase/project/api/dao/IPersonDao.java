package com.cvdatabase.project.api.dao;

import com.cvdatabase.project.entities.Person;

import java.util.List;

public interface IPersonDao extends IAGenericDao<Person> {

    List<Person> getByFirstName(String firstName);

    List<Person> getByLastName(String lastName);

    List<Person> getByTechnologyName(String name);

    List<Person> getByFullName(String firstName, String lastName);
}
