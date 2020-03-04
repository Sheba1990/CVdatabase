package com.cvdatabase.project.controllers;

import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.api.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CRUD
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    IPersonService personService;

    //Create
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto addPerson(@RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }

    //Read
    @GetMapping
    public List<PersonDto> getAll() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    public PersonDto getById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/first_name/{firstName}")
    public List<PersonDto> getByFirstName(@PathVariable String firstName) {
        return personService.getByFirstName(firstName);
    }

    @GetMapping(value = "/last_name/{lastName}")
    public List<PersonDto> getByLastName(@PathVariable String lastName) {
        return personService.getByLastName(lastName);
    }

    @GetMapping(value = "/full_name/{firstName}/{lastName}")
    public List<PersonDto> getByFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return personService.getByFullName(firstName, lastName);
    }

    @GetMapping(value = "/technology/{name}")
    public List<PersonDto> getByTechnologyName(@PathVariable String name) {
        return personService.getByTechnologyName(name);
    }

    //Update
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePerson(@PathVariable long id, @RequestBody PersonDto personDto) {
        personService.updatePerson(id, personDto);
    }

    @PutMapping(value = "/add_technology/technologyIdt}/{personId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto addTechnologyToPerson(@PathVariable long technologyId, @PathVariable long personId) {
        return personService.addTechnologyToPerson(technologyId, personId);
    }

    @PutMapping(value = "/add_contacts/{contactDataId}/{personId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto addContactDataToPerson(@PathVariable long contactDataId, @PathVariable long personId) {
        return personService.addContactDataToPerson(contactDataId, personId);
    }

    //Delete
    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable long id) {
        personService.deletePerson(id);
    }
}

