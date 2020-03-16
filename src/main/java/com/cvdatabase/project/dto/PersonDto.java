package com.cvdatabase.project.dto;

import com.cvdatabase.project.entities.Gender;
import com.cvdatabase.project.entities.Person;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class PersonDto extends ADto {

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
    private List<TechnologyDto> technologies;

    public static List<PersonDto> convertList(List<Person> personList) {
        List<PersonDto> persons = new ArrayList<>();
        for (Person person : personList) {
            List<TechnologyDto> technologies = new ArrayList();
            PersonDto personDto = new PersonDto();
            personDto.setId(person.getId());
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setMiddleName(person.getMiddleName());
            personDto.setGender(person.getGender());
            personDto.setBirthDate(person.getBirthDate());
            if (person.getContactData() != null) {
                personDto.setMobilePhone(person.getContactData().getMobilePhone());
            } else {
                personDto.setMobilePhone(null);
            }
            persons.add(personDto);
        }
        return persons;
    }

    public static PersonDto entityToDto(Person person) {
        List<TechnologyDto> technologies = new ArrayList();
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setMiddleName(person.getMiddleName());
        personDto.setGender(person.getGender());
        personDto.setBirthDate(person.getBirthDate());
        if (person.getContactData() != null) {
            personDto.setMobilePhone(person.getContactData().getMobilePhone());
        } else {
            personDto.setMobilePhone(null);
        }
        return personDto;
    }

    public PersonDto() {
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.middleName = person.getMiddleName();
        this.gender = person.getGender();
        this.birthDate = person.getBirthDate();
        this.mobilePhone = person.getContactData().getMobilePhone();
        this.technologies = TechnologyDto.convertList(person.getTechnologies());
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

    public List<TechnologyDto> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyDto> technologies) {
        this.technologies = technologies;
    }
}
