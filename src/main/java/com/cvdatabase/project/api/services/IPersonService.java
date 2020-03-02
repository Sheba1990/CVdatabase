package com.cvdatabase.project.api.services;

import com.cvdatabase.project.api.dto.PersonDto;

import java.util.List;

public interface IPersonService {

    public List<PersonDto> getAllPersons();

    PersonDto addPerson(PersonDto personDto);

    PersonDto getPersonById(long id);

    public List<PersonDto> getByFirstName(String firstName);

    public List<PersonDto> getByLastName(String lastName);

    public List<PersonDto> getByTechnologyName(String name);

    public List<PersonDto> getByFullName(String firstName, String lastName);

    void updatePerson(long id, PersonDto personDto);

    void deletePerson(long id);

    public PersonDto addTechnologyToPerson(long technologyId, long personId);

    public PersonDto addContactDataToPerson(long contactDataId, long personId);

}
