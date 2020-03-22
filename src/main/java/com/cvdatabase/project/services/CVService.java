package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.ICVDao;
import com.cvdatabase.project.api.dao.IContactDataDao;
import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.api.services.ICVService;
import com.cvdatabase.project.dto.CVDto;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.entities.CV;
import com.cvdatabase.project.entities.ContactData;
import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CVService implements ICVService {

    @Autowired
    ICVDao cvDao;

    @Autowired
    IPersonDao personDao;

    @Autowired
    IContactDataDao contactDataDao;

    public List<CVDto> getAllCVs() {
        return CVDto.convertList(cvDao.getAll());
    }

    public CVDto addCV(CVDto cvDto, PersonDto personDto, ContactDataDto contactDataDto) {
        ContactData contactData = new ContactData();
        contactData.setMobilePhone(contactDataDto.getMobilePhone());
        contactData.setEmail(contactDataDto.getEmail());
        contactData.setGitHub(contactDataDto.getGitHub());
        contactData.setLinkedIn(contactDataDto.getLinkedIn());
        contactData.setSkype(contactDataDto.getSkype());
        contactDataDao.create(contactData);

        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setMiddleName(personDto.getMiddleName());
        person.setGender(personDto.getGender());
        person.setBirthDate(personDto.getBirthDate());
        person.setContactData(contactData);
        personDao.create(person);

        CV cv = new CV();
        cv.setPerson(person);
        CV testCv = cvDao.create(cv);

        return CVDto.entityToDto(testCv);
    }

    public CVDto getCVbyId(long id) {
        return CVDto.entityToDto(cvDao.get(id));
    }

    public List<CVDto> getByTechnologyName(String name) {
        return CVDto.convertList(cvDao.getCVByTechnologyName(name));
    }

    public List<CVDto> getCVByPersonFirstName(String firstName) {
        return CVDto.convertList(cvDao.getCVByPersonFirstName(firstName));
    }

    public List<CVDto> getCVByPersonLastName(String lastName) {
        return CVDto.convertList(cvDao.getCVByPersonLastName(lastName));
    }

    public List<CVDto> getCVByPersonFullName(String firstName, String lastName) {
        return CVDto.convertList(cvDao.getCVByPersonFullName(firstName, lastName));
    }

    public void updateCV(long id, CVDto cvDto) {
        CV cv = cvDao.get(id);
        if (cvDto != null) {
            cv.setPerson(cv.getPerson());
        }
        cvDao.update(cv);
    }

    public void deleteCV(long id) {
        cvDao.delete(cvDao.get(id));
    }

    public CVDto addPersonToCV(long personId, long cvId) {
        Person person = personDao.get(personId);
        CV cv = cvDao.get(cvId);
        cv.setPerson(person);
        cvDao.update(cv);
        return CVDto.entityToDto(cv);
    }
}
