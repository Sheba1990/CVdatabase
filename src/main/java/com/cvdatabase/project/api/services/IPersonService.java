package com.cvdatabase.project.api.services;

import com.cvdatabase.project.dto.PersonDto;

import java.util.List;

public interface IPersonService {

    PersonDto addPerson(PersonDto personDto);

    public List<PersonDto> getAllPersons();

    PersonDto getPersonById(long id);

    public List<PersonDto> getByFirstName(String firstName);

    public List<PersonDto> getByLastName(String lastName);

    public List<PersonDto> getByFullName(String firstName, String lastName);

    public List<PersonDto> getByTechnologyName(String name);

    void updatePerson(long id, PersonDto personDto);

    void deletePerson(long id);

    public PersonDto addTechnologyToPerson(long technologyId, long personId);

    public PersonDto addContactDataToPerson(long contactDataId, long personId);

}
