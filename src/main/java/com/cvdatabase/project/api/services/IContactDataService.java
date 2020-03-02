package com.cvdatabase.project.api.services;

import com.cvdatabase.project.api.dto.ContactDataDto;
import com.cvdatabase.project.entities.ContactData;

import java.util.List;

public interface IContactDataService {

    public List<ContactDataDto> getAllContactData();

    ContactDataDto addContactData(ContactData contactData);

    ContactDataDto getContactDataById(long id);

    void updateContactData(long id, ContactDataDto contactDataDto);

    void deleteContactData(long id);

}
