package com.cvdatabase.project.api.services;

import com.cvdatabase.project.api.dto.ContactDataDto;

import java.util.List;

public interface IContactDataService {

    public List<ContactDataDto> getAllContactData();

    ContactDataDto addContactData(ContactDataDto contactDataDto);

    ContactDataDto getContactDataById(long id);

    void updateContactData(long id, ContactDataDto contactDataDto);

    void deleteContactData(long id);

}
