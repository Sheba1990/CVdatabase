package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.IContactDataDao;
import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.api.dao.ITechnologyDao;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.api.services.IPersonService;
import com.cvdatabase.project.entities.ContactData;
import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
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

    public List<PersonDto> getAllPersons() {
        return PersonDto.convertList(personDao.getAll());
    }

    public PersonDto addPerson(PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setMiddleName(personDto.getMiddleName());
        person.setGender(personDto.getGender());
        person.setBirthDate(personDto.getBirthDate());
        return PersonDto.entityToDto(personDao.create(person));
    }

    public PersonDto getPersonById(long id) {
        return PersonDto.entityToDto(personDao.get(id));
    }

    public List<PersonDto> getByFirstName(String firstName) {
        return PersonDto.convertList(personDao.getByFirstName(firstName));
    }

    public List<PersonDto> getByLastName(String lastName) {
        return PersonDto.convertList(personDao.getByLastName(lastName));
    }

    public List<PersonDto> getByTechnologyName(String name) {
        return PersonDto.convertList(personDao.getByTechnologyName(name));
    }

    public List<PersonDto> getByFullName(String firstName, String lastName) {
        return PersonDto.convertList(personDao.getByFullName(firstName, lastName));
    }

    public void updatePerson(long id, PersonDto personDto) {
        Person person = personDao.get(id);
        if (personDto.getFirstName() != null && !StringUtils.isEmpty(personDto.getFirstName())) {
            person.setFirstName(personDto.getFirstName());
        }
        if (personDto.getLastName() != null && !StringUtils.isEmpty(personDto.getLastName())) {
            person.setLastName(personDto.getLastName());
        }
        if (personDto.getMiddleName() != null && !StringUtils.isEmpty(personDto.getMiddleName())) {
            person.setMiddleName(personDto.getMiddleName());
        }
        if (personDto.getGender() != null) {
            person.setGender(personDto.getGender());
        }
        if (personDto.getBirthDate() != null && !StringUtils.isEmpty(personDto.getBirthDate())) {
            person.setBirthDate(personDto.getBirthDate());
        }
        personDao.update(person);
    }

    public void deletePerson(long id) {
        personDao.delete(personDao.get(id));
    }

    public PersonDto addTechnologyToPerson(long technologyId, long personId) {
        Person person = personDao.get(personId);
        Technology technology = technologyDao.get(technologyId);
        person.getTechnologies().add(technology);
        technology.getPersons().add(person);
        personDao.update(person);
        return PersonDto.entityToDto(person);
    }

    public PersonDto addContactDataToPerson(long contactDataId, long personId) {
        ContactData contactData = contactDataDao.get(contactDataId);
        Person person = personDao.get(personId);
        person.setContactData(contactData);
        personDao.update(person);
        return PersonDto.entityToDto(person);
    }
}
