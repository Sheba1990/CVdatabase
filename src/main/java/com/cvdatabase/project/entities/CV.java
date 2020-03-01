package com.cvdatabase.project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cv_table")
public class CV extends AEntity {

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "cv")
    private Person person;

    private ContactData contactData;

    private List<Technology> technologies;

    public CV() {
    }

    public CV(Person person, ContactData contactData, List<Technology> technologies) {
        this.person = person;
        this.contactData = contactData;
        this.technologies = technologies;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
