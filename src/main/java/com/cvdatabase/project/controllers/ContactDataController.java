package com.cvdatabase.project.controllers;

import com.cvdatabase.project.api.dto.ContactDataDto;
import com.cvdatabase.project.api.services.IContactDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CRUD
@RestController
@RequestMapping("/contacts")
public class ContactDataController {

    @Autowired
    IContactDataService contactDataService;

    //Create
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactDataDto addContactData(@RequestBody ContactDataDto contactDataDto) {
        return contactDataService.addContactData(contactDataDto);
    }

    //Read
    @GetMapping
    public List<ContactDataDto> getAllContactData() {
        return contactDataService.getAllContactData();
    }

    @GetMapping(value = "/{id}")
    public ContactDataDto getContactDataById(@PathVariable long id) {
        return contactDataService.getContactDataById(id);
    }

    //Update
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateContactData(@PathVariable long id, @RequestBody ContactDataDto contactDataDto) {
        contactDataService.updateContactData(id, contactDataDto);
    }

    //Delete
    @DeleteMapping(value = "/{id}")
    public void deleteContactData(long id) {
        contactDataService.deleteContactData(id);
    }
}
