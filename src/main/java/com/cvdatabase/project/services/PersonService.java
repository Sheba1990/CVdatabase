package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.IContactDataDao;
import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.api.dao.ITechnologyDao;
import com.cvdatabase.project.api.dto.PersonDto;
import com.cvdatabase.project.api.services.IPersonService;
import com.cvdatabase.project.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    IPersonDao personDao;

    @Autowired
    ITechnologyDao technologyDao;

    @Autowired
    IContactDataDao contactDataDao;

    @Override
    public List<PersonDto> getAllPersons() {
        return PersonDto.convertList(personDao.getAll());
    }

    @Override
    public PersonDto addPerson(PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setMiddleName(personDto.getMiddleName());
        person.setGender(personDto.getGender());
        person.setBirthDate(personDto.getBirthDate());
        return PersonDto.entityToDto(personDao.create(person));
    }

    @Override
    public PersonDto getPersonById(long id) {
        return null;
    }

    @Override
    public List<PersonDto> getByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<PersonDto> getByLastName(String lastName) {
        return null;
    }

    @Override
    public List<PersonDto> getByTechnologyName(String name) {
        return null;
    }

    @Override
    public List<PersonDto> getByFullName(String firstName, String lastName) {
        return null;
    }

    @Override
    public void updatePerson(long id, PersonDto personDto) {

    }

    @Override
    public void deletePerson(long id) {

    }

    @Override
    public PersonDto addTechnologyToPerson(long technologyId, long personId) {
        return null;
    }

    @Override
    public PersonDto addContactDataToPerson(long contactDataId, long personId) {
        return null;
    }
}
