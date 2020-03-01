package com.cvdatabase.project.entities;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContactData.class)
public class ContactData_ extends com.cvdatabase.project.entities.AEntity_ {

    public static volatile SingularAttribute<ContactData, String> mobilePhone;
    public static volatile SingularAttribute<ContactData, String> landLinePhone;
    public static volatile SingularAttribute<ContactData, String> email;
    public static volatile SingularAttribute<ContactData, String> gitHub;
    public static volatile SingularAttribute<ContactData, String> linkedIn;
    public static volatile SingularAttribute<ContactData, String> jobsTutBy;
    public static volatile SingularAttribute<ContactData, String> personalSite;
    public static volatile SingularAttribute<ContactData, Person> person;

    public static final String MOBILE_PHONE = "mobilePhone";
    public static final String LAND_LINE_PHONE = "landLinePhone";
    public static final String EMAIL = "email";
    public static final String GITHUB = "gitHub";
    public static final String LINKED_IN = "linkedIn";
    public static final String JOBS_TUT_BY = "jobsTutBy";
    public static final String PERSONAL_SITE = "personalSite";
    public static final String PERSON = "person";

}
