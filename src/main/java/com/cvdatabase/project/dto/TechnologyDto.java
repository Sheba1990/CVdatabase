package com.cvdatabase.project.dto;

import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.Technology;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class TechnologyDto extends ADto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PersonDto> persons;

    public static List<TechnologyDto> convertList(List<Technology> technologyList) {
        List<TechnologyDto> technologies = new ArrayList();
        for (Technology technology : technologyList) {
            TechnologyDto technologyDto = new TechnologyDto();
            technologyDto.setName(technology.getName());
            technologies.add(technologyDto);
        }
        return technologies;
    }

    public static TechnologyDto entityToDto(Technology technology) {
        List<PersonDto> persons = new ArrayList();
        TechnologyDto technologyDto = new TechnologyDto();
        technologyDto.setId(technology.getId());
        technologyDto.setName(technology.getName());
        for (Person person : technology.getPersons()) {
            PersonDto personDto = new PersonDto();
            if (technology.getPersons() != null) {
                personDto.setFirstName(person.getFirstName());
                personDto.setLastName(person.getLastName());
                personDto.setMobilePhone(person.getContactData().getMobilePhone());
                personDto.setEmail(person.getContactData().getEmail());
                persons.add(personDto);
            } else {
                technology.setPersons(null);
            }
        }
        technologyDto.setPersons(persons);
        return technologyDto;
    }

    public TechnologyDto() {
    }

    public TechnologyDto(Technology technology) {
        this.id = technology.getId();
        this.name = technology.getName();
        this.persons = PersonDto.convertList(technology.getPersons());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonDto> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonDto> persons) {
        this.persons = persons;
    }
}
