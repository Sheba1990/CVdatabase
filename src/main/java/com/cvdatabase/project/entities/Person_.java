package com.cvdatabase.project.entities;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public class Person_ extends com.cvdatabase.project.entities.AEntity_ {

    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, String> middleName;
    public static volatile SingularAttribute<Person, String> sex;
    public static volatile SingularAttribute<Person, String> birthDate;
    public static volatile SingularAttribute<Person, ContactData> contactData;
    public static volatile SingularAttribute<Person, Technology> technologies;

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String SEX = "sex";
    public static final String BIRTH_DATE = "birthDate";
    public static final String CONTACT_DATA = "contactData";
    public static final String TECHNOLOGIES = "technologies";
}
