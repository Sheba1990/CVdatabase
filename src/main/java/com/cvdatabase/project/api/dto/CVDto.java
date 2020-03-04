package com.cvdatabase.project.api.dto;

import com.cvdatabase.project.entities.CV;
import com.cvdatabase.project.entities.Gender;
import com.cvdatabase.project.entities.Technology;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class CVDto extends ADto {

    private String firstName;

    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String middleName;

    private Gender gender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String birthDate;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Technology> technologies;

    public CVDto() {
    }

    public static List<CVDto> convertList(List<CV> cvList) {
        List<CVDto> cvs = new ArrayList<>();
        for (CV cv : cvList) {
            CVDto cvDto = new CVDto();
            cvDto.setId(cv.getId());
            cvDto.setFirstName(cv.getPerson().getFirstName());
            cvDto.setLastName(cv.getPerson().getLastName());
            cvDto.setMiddleName(cv.getPerson().getMiddleName());
            cvDto.setGender(cv.getPerson().getGender());
            cvDto.setBirthDate(cv.getPerson().getBirthDate());
            cvDto.setMobilePhone(cv.getPerson().getContactData().getMobilePhone());
            cvDto.setLandLinePhone(cv.getPerson().getContactData().getLandLinePhone());
            cvDto.setEmail(cv.getPerson().getContactData().getEmail());
            cvDto.setGitHub(cv.getPerson().getContactData().getGitHub());
            cvDto.setLinkedIn(cv.getPerson().getContactData().getLinkedIn());
            cvDto.setJobsTutBy(cv.getPerson().getContactData().getJobsTutBy());
            cvDto.setPersonalSite(cv.getPerson().getContactData().getPersonalSite());
            cvDto.setTechnologies(cv.getPerson().getTechnologies());
            cvs.add(cvDto);
        }
        return cvs;
    }

    public static CVDto entityToDto(CV cv) {
        CVDto cvDto = new CVDto();
        cvDto.setId(cv.getId());
        if (cv.getPerson() != null) {
            cvDto.setFirstName(cv.getPerson().getFirstName());
            cvDto.setLastName(cv.getPerson().getLastName());
            cvDto.setMiddleName(cv.getPerson().getMiddleName());
            cvDto.setGender(cv.getPerson().getGender());
            cvDto.setBirthDate(cv.getPerson().getBirthDate());
        }
        if (cv.getPerson().getContactData() != null) {
            cvDto.setMobilePhone(cv.getPerson().getContactData().getMobilePhone());
            cvDto.setLandLinePhone(cv.getPerson().getContactData().getLandLinePhone());
            cvDto.setEmail(cv.getPerson().getContactData().getEmail());
            cvDto.setGitHub(cv.getPerson().getContactData().getGitHub());
            cvDto.setLinkedIn(cv.getPerson().getContactData().getLinkedIn());
            cvDto.setJobsTutBy(cv.getPerson().getContactData().getJobsTutBy());
            cvDto.setPersonalSite(cv.getPerson().getContactData().getPersonalSite());
        }
        if (cv.getPerson().getTechnologies() != null) {
            cvDto.setTechnologies(cv.getPerson().getTechnologies());
        }
        return cvDto;
    }

    public CVDto(CV cv) {
        this.id = cv.getId();
        this.firstName = cv.getPerson().getFirstName();
        this.lastName = cv.getPerson().getLastName();
        this.middleName = cv.getPerson().getMiddleName();
        this.gender = cv.getPerson().getGender();
        this.birthDate = cv.getPerson().getBirthDate();
        this.mobilePhone = cv.getPerson().getContactData().getMobilePhone();
        this.landLinePhone = cv.getPerson().getContactData().getLandLinePhone();
        this.email = cv.getPerson().getContactData().getEmail();
        this.gitHub = cv.getPerson().getContactData().getGitHub();
        this.linkedIn = cv.getPerson().getContactData().getLinkedIn();
        this.jobsTutBy = cv.getPerson().getContactData().getJobsTutBy();
        this.personalSite = cv.getPerson().getContactData().getPersonalSite();
        this.technologies = cv.getPerson().getTechnologies();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
