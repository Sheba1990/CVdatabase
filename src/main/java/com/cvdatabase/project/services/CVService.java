package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.ICVDao;
import com.cvdatabase.project.api.dao.IContactDataDao;
import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.api.dao.ITechnologyDao;
import com.cvdatabase.project.api.services.ICVService;
import com.cvdatabase.project.dto.CVDto;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.dto.TechnologyDto;
import com.cvdatabase.project.entities.CV;
import com.cvdatabase.project.entities.ContactData;
import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
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

    @Autowired
    ITechnologyDao technologyDao;

    public List<CVDto> getAllCVs() {
        return CVDto.convertList(cvDao.getAll());
    }

    public CVDto addCV(CVDto cvDto,
                       PersonDto personDto,
                       ContactDataDto contactDataDto,
                       int[] technologies) {

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
        
        if (technologies != null) {
            Technology technology = null;
            for (long i = 0; i < technologies.length; i++) {
                if (technologyDao.get(i) != null) {
                    technology = new Technology();
                    technology.setId(i);
                    person.getTechnologies().add(technology);
                    technology.getPersons().add(person);
                }
            }
        }
        personDao.create(person);

        CV cv = new CV();
        cv.setPerson(person);
        CV newCV = cvDao.create(cv);

        return CVDto.entityToDto(newCV);
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

    public void updateCV(long id,
                         CVDto cvDto,
                         PersonDto personDto,
                         ContactDataDto contactDataDto) {
        CV cv = cvDao.get(id);
        Person person = cv.getPerson();
        ContactData contactData = cv.getPerson().getContactData();
        if (cv.getPerson() != null) {
            if (cvDto.getMobilePhone() != null && !StringUtils.isEmpty(cvDto.getMobilePhone())) {
                contactData.setMobilePhone(contactDataDto.getMobilePhone());
            }
            if (cvDto.getEmail() != null && !StringUtils.isEmpty(cvDto.getEmail())) {
                contactData.setEmail(contactDataDto.getEmail());
            }
            if (cvDto.getGitHub() != null && !StringUtils.isEmpty(cvDto.getGitHub())) {
                contactData.setGitHub(contactDataDto.getGitHub());
            }
            if (cvDto.getSkype() != null && !StringUtils.isEmpty(cvDto.getSkype())) {
                contactData.setSkype(contactDataDto.getSkype());
            }
            if (cvDto.getLinkedIn() != null && !StringUtils.isEmpty(cvDto.getLinkedIn())) {
                contactData.setLinkedIn(contactDataDto.getLinkedIn());
            }
            contactDataDao.update(contactData);

            if (cvDto.getFirstName()!=null && !StringUtils.isEmpty(cvDto.getFirstName())) {
                person.setFirstName(personDto.getFirstName());
            }
            if (cvDto.getLastName() != null && !StringUtils.isEmpty(cvDto.getLastName())) {
                person.setLastName(personDto.getLastName());
            }
            if (cvDto.getMiddleName() != null && !StringUtils.isEmpty(cvDto.getMiddleName())) {
                person.setMiddleName(personDto.getMiddleName());
            }
            if (cvDto.getBirthDate() != null && !StringUtils.isEmpty(cvDto.getBirthDate())) {
                person.setBirthDate(personDto.getBirthDate());
            }
            if (cvDto.getGender() != null) {
                person.setGender(personDto.getGender());
            }
            personDao.update(person);
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
