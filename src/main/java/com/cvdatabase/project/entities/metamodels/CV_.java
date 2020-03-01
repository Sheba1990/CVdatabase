package com.cvdatabase.project.entities.metamodels;

import com.cvdatabase.project.entities.CV;
import com.cvdatabase.project.entities.ContactData;
import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.Technology;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CV.class)
public class CV_ extends AEntity_ {

    public static volatile SingularAttribute<CV, Person> person;
    public static volatile SingularAttribute<CV, ContactData> contactData;
    public static volatile SingularAttribute<CV, Technology> technologies;

    public static final String PERSON = "person";
    public static final String CONTACT_DATA = "contactData";
    public static final String TECHNOLOGIES = "technologies";
}
