package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.IContactDataDao;
import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.api.services.IContactDataService;
import com.cvdatabase.project.entities.ContactData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactDataService implements IContactDataService {

    @Autowired
    IContactDataDao contactDataDao;

    @Autowired
    IPersonDao personDao;

    public ContactDataDto addContactData(ContactDataDto contactDataDto) {
        ContactData contactData = new ContactData();
        contactData.setMobilePhone(contactDataDto.getMobilePhone());
        contactData.setEmail(contactDataDto.getEmail());
        contactData.setGitHub(contactDataDto.getGitHub());
        contactData.setLinkedIn(contactDataDto.getLinkedIn());
        contactData.setJobsTutBy(contactDataDto.getJobsTutBy());
        return ContactDataDto.entityToDto(contactDataDao.create(contactData));
    }

    public List<ContactDataDto> getAllContactData() {
        return ContactDataDto.convertList(contactDataDao.getAll());
    }

    public ContactDataDto getContactDataById(long id) {
        return ContactDataDto.entityToDto(contactDataDao.get(id));
    }

    public void updateContactData(long id, ContactDataDto contactDataDto) {
        ContactData contactData = contactDataDao.get(id);
        if (contactDataDto.getMobilePhone() != null && !StringUtils.isEmpty(contactDataDto.getMobilePhone())) {
            contactData.setMobilePhone(contactDataDto.getMobilePhone());
        }
        if (contactDataDto.getEmail() != null && !StringUtils.isEmpty(contactDataDto.getEmail())) {
            contactData.setEmail(contactDataDto.getEmail());
        }
        if (contactDataDto.getGitHub() != null && !StringUtils.isEmpty(contactDataDto.getGitHub())) {
            contactData.setGitHub(contactDataDto.getGitHub());
        }
        if (contactDataDto.getLinkedIn() != null && !StringUtils.isEmpty(contactDataDto.getLinkedIn())) {
            contactData.setLinkedIn(contactDataDto.getLinkedIn());
        }
        if (contactDataDto.getJobsTutBy() != null && !StringUtils.isEmpty(contactDataDto.getJobsTutBy())) {
            contactData.setJobsTutBy(contactDataDto.getJobsTutBy());
        }
        contactDataDao.update(contactData);
    }

    public void deleteContactData(long id) {
        contactDataDao.delete(contactDataDao.get(id));
    }
}
