package com.cvdatabase.project.controllers;

import com.cvdatabase.project.api.services.IPersonService;
import com.cvdatabase.project.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//CRUD
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    IPersonService personService;

    //Create
    @GetMapping(value = "/new")
    public ModelAndView showNewPersonForm() {
        PersonDto personDto = new PersonDto();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/new_person");
        modelAndView.addObject("person", personDto);
        return modelAndView;
    }

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addPerson(PersonDto personDto) {
        ModelAndView modelAndView = new ModelAndView();
        personService.addPerson(personDto);
        modelAndView.setViewName("redirect:/persons");
        return modelAndView;
    }

    //Read
    @GetMapping
    public ModelAndView getAllPersons(){
        ModelAndView modelAndView = new ModelAndView();
        List<PersonDto> persons = personService.getAllPersons();
        modelAndView.setViewName("views/persons");
        modelAndView.addObject("personsList", persons);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public PersonDto getById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/first_name/{firstName}")
    public ModelAndView getByFirstName(@RequestParam String firstName) {
        ModelAndView modelAndView = new ModelAndView();
        List<PersonDto> persons = personService.getByFirstName(firstName);
        modelAndView.setViewName("views/persons");
        modelAndView.addObject("personsList", persons);
        modelAndView.addObject("firstName", firstName);
        return modelAndView;
    }

    @GetMapping(value = "/last_name/{lastName}")
    public ModelAndView getByLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView();
        List<PersonDto> persons = personService.getByLastName(lastName);
        modelAndView.setViewName("views/persons");
        modelAndView.addObject("personsList", persons);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
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
    @GetMapping(value = "/edit_person/{id}")
    public ModelAndView showEditCVFrom(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/edit_person");
        PersonDto personDto = personService.getPersonById(id);
        modelAndView.addObject("person", personDto);
        return modelAndView;
    }

    @PostMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView editPerson(@PathVariable("id") long id,
                                   PersonDto personDto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/persons");
        personService.updatePerson(id, personDto);
        return modelAndView;
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
    @PostMapping(value = "/delete/{id}")
    public ModelAndView deletePerson(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        personService.deletePerson(id);
        modelAndView.setViewName("redirect:/persons");
        return modelAndView;
    }
}

