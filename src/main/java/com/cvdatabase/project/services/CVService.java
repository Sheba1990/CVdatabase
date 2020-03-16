package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.ICVDao;
import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.api.services.ICVService;
import com.cvdatabase.project.dto.CVDto;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.entities.CV;
import com.cvdatabase.project.entities.ContactData;
import com.cvdatabase.project.entities.Gender;
import com.cvdatabase.project.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CVService implements ICVService {

    @Autowired
    ICVDao cvDao;

    @Autowired
    IPersonDao personDao;

    public List<CVDto> getAllCVs() {
        return CVDto.convertList(cvDao.getAll());
    }

    public CVDto addCV(CVDto cvDto) {
        CV cv = new CV();

        return CVDto.entityToDto(cvDao.create(cv));
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
