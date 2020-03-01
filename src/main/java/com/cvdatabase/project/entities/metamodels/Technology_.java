package com.cvdatabase.project.entities.metamodels;

import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.Technology;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Technology.class)
public class Technology_ extends AEntity_ {

    public static volatile SingularAttribute<Technology, String> name;
    public static volatile SingularAttribute<Technology, Person> persons;

    public static final String NAME = "name";
    public static final String PERSONS = "persons";


}
