package com.cvdatabase.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "contact_data_table")
public class ContactData extends AEntity {

    @Column(name = "mobile_phone_number")
    private String mobilePhone;

    @Column(name = "landline_phone_number")
    private String landLinePhone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "gitHub")
    private String gitHub;

    @Column(name = "linked_in")
    private String linkedIn;

    @Column(name = "jobs_tut_by")
    private String jobsTutBy;

    @Column(name = "dev_by")
    private String devBy;

    @Column(name = "personal_site")
    private String personalSite;

    @OneToOne(mappedBy = "contactData")
    private Person person;

    public ContactData() {
    }

    public ContactData(String mobilePhone, String landLinePhone, @Email String email, String gitHub, String linkedIn, String jobsTutBy, String devBy, String personalSite, Person person) {
        this.mobilePhone = mobilePhone;
        this.landLinePhone = landLinePhone;
        this.email = email;
        this.gitHub = gitHub;
        this.linkedIn = linkedIn;
        this.jobsTutBy = jobsTutBy;
        this.devBy = devBy;
        this.personalSite = personalSite;
        this.person = person;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getLandLinePhone() {
        return landLinePhone;
    }

    public void setLandLinePhone(String landLinePhone) {
        this.landLinePhone = landLinePhone;
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

    public String getJobsTutBy() {
        return jobsTutBy;
    }

    public void setJobsTutBy(String jobsTutBy) {
        this.jobsTutBy = jobsTutBy;
    }

    public String getPersonalSite() {
        return personalSite;
    }

    public void setPersonalSite(String personalSite) {
        this.personalSite = personalSite;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDevBy() {
        return devBy;
    }

    public void setDevBy(String devBy) {
        this.devBy = devBy;
    }
}
