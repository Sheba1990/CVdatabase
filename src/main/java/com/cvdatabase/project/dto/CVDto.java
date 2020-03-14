package com.cvdatabase.project.dto;

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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Gender gender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String birthDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mobilePhone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gitHub;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String linkedIn;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String jobsTutBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TechnologyDto> technologies;

    public CVDto() {
    }

    public static List<CVDto> convertList(List<CV> cvList) {
        List<CVDto> cvs = new ArrayList<>();
        for (CV cv : cvList) {
            List<TechnologyDto> technologies = new ArrayList<>();
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
                cvDto.setEmail(cv.getPerson().getContactData().getEmail());
                cvDto.setGitHub(cv.getPerson().getContactData().getGitHub());
                cvDto.setLinkedIn(cv.getPerson().getContactData().getLinkedIn());
                cvDto.setJobsTutBy(cv.getPerson().getContactData().getJobsTutBy());
            }
            for (Technology technology : cv.getPerson().getTechnologies()) {
                TechnologyDto technologyDto = new TechnologyDto();
                if (cv.getPerson().getTechnologies() != null) {
                    technologyDto.setName(technology.getName());
                    technologies.add(technologyDto);
                } else {
                    cvDto.setTechnologies(null);
                }
            }
            cvDto.setTechnologies(technologies);
            cvs.add(cvDto);
        }
        return cvs;
    }

    public static CVDto entityToDto(CV cv) {
        CVDto cvDto = new CVDto();
        List<TechnologyDto> technologies = new ArrayList<>();
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
            cvDto.setEmail(cv.getPerson().getContactData().getEmail());
            cvDto.setGitHub(cv.getPerson().getContactData().getGitHub());
            cvDto.setLinkedIn(cv.getPerson().getContactData().getLinkedIn());
            cvDto.setJobsTutBy(cv.getPerson().getContactData().getJobsTutBy());
        }
        for (Technology technology : cv.getPerson().getTechnologies()) {
            TechnologyDto technologyDto = new TechnologyDto();
            if (cv.getPerson().getTechnologies() != null) {
                technologyDto.setName(technology.getName());
                technologies.add(technologyDto);
            } else {
                cvDto.setTechnologies(null);
            }
        }
        cvDto.setTechnologies(technologies);
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
        this.email = cv.getPerson().getContactData().getEmail();
        this.gitHub = cv.getPerson().getContactData().getGitHub();
        this.linkedIn = cv.getPerson().getContactData().getLinkedIn();
        this.jobsTutBy = cv.getPerson().getContactData().getJobsTutBy();
        this.technologies = TechnologyDto.convertList(cv.getPerson().getTechnologies());
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

    public List<TechnologyDto > getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyDto> technologies) {
        this.technologies = technologies;
    }

}
