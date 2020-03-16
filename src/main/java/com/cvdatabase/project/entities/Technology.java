package com.cvdatabase.project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "technologies_table")
public class Technology extends AEntity {

    @Column(name = "technology_name")
    private String name;

    @ManyToMany(mappedBy = "technologies")
    private List<Person> persons;

    public Technology() {
    }

    public Technology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
