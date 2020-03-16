package com.cvdatabase.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "contact_data_table")
public class ContactData extends AEntity {

    @Column(name = "mobilephone")
    private String mobilePhone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "github")
    private String gitHub;

    @Column(name = "skype")
    private String skype;

    @Column(name = "linkedin")
    private String linkedIn;

    @OneToOne(mappedBy = "contactData")
    private Person person;

    public ContactData() {
    }

    public ContactData(String mobilePhone, @Email String email, String gitHub, String skype, String linkedIn, String jobsTutBy) {
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.gitHub = gitHub;
        this.skype = skype;
        this.linkedIn = linkedIn;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
}
