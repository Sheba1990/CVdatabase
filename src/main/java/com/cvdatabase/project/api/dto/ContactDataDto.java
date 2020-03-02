package com.cvdatabase.project.api.dto;

import com.cvdatabase.project.entities.ContactData;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class ContactDataDto extends ADto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobilePhone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String landLinePhone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gitHub;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String linkedIn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String jobsTutBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String personalSite;

    private String personFirstName;

    private String personLastName;

    public static List<ContactDataDto> convertList(List<ContactData> contactDataList) {
        List<ContactDataDto> contacts = new ArrayList();
        for (ContactData contactData : contactDataList) {
            ContactDataDto contactDataDto = new ContactDataDto();
            contactDataDto.setId(contactData.getId());
            contactDataDto.setMobilePhone(contactData.getMobilePhone());
            contactDataDto.setLandLinePhone(contactData.getLandLinePhone());
            contactDataDto.setEmail(contactData.getEmail());
            contactDataDto.setGitHub(contactData.getGitHub());
            contactDataDto.setLinkedIn(contactData.getLinkedIn());
            contactDataDto.setJobsTutBy(contactData.getJobsTutBy());
            contactDataDto.setPersonalSite(contactData.getPersonalSite());
            if (contactData.getPerson() != null) {
                contactDataDto.setPersonFirstName(contactData.getPerson().getFirstName());
                contactDataDto.setPersonLastName(contactData.getPerson().getLastName());
            } else {
                contactData.setPerson(null);
            }
            contacts.add(contactDataDto);
        }
        return contacts;
    }

    public static ContactDataDto entityToDto(ContactData contactData) {
        ContactDataDto contactDataDto = new ContactDataDto();
        contactDataDto.setId(contactData.getId());
        contactDataDto.setMobilePhone(contactData.getMobilePhone());
        contactDataDto.setLandLinePhone(contactData.getLandLinePhone());
        contactDataDto.setEmail(contactData.getEmail());
        contactDataDto.setGitHub(contactData.getGitHub());
        contactDataDto.setLinkedIn(contactData.getLinkedIn());
        contactDataDto.setJobsTutBy(contactData.getJobsTutBy());
        contactDataDto.setPersonalSite(contactData.getPersonalSite());
        if (contactData.getPerson() != null) {
            contactDataDto.setPersonFirstName(contactData.getPerson().getFirstName());
            contactDataDto.setPersonLastName(contactData.getPerson().getLastName());
        } else {
            contactData.setPerson(null);
        }
        return contactDataDto;
    }

    public ContactDataDto() {
    }

    public ContactDataDto(ContactData contactData) {
        this.id = contactData.getId();
        this.mobilePhone = contactData.getMobilePhone();
        this.landLinePhone = contactData.getLandLinePhone();
        this.email = contactData.getEmail();
        this.gitHub = contactData.getGitHub();
        this.jobsTutBy = contactData.getJobsTutBy();
        this.linkedIn = contactData.getLinkedIn();
        this.personalSite = contactData.getPersonalSite();
        this.personFirstName = contactData.getPerson().getFirstName();
        this.personLastName = contactData.getPerson().getLastName();
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

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }
}
