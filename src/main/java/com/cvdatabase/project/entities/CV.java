package com.cvdatabase.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "cv_table")
public class CV extends AEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public CV() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
