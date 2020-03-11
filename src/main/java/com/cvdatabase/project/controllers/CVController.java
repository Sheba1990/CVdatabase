package com.cvdatabase.project.controllers;

import com.cvdatabase.project.api.services.ICVService;
import com.cvdatabase.project.api.services.IContactDataService;
import com.cvdatabase.project.api.services.IPersonService;
import com.cvdatabase.project.api.services.ITechnologyService;
import com.cvdatabase.project.dto.CVDto;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.dto.TechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/cvs")
public class CVController {

    @Autowired(required = true)
    ICVService cvService;

    @Autowired
    IPersonService personService;

    @Autowired
    IContactDataService contactDataService;

    @Autowired
    ITechnologyService technologyService;

    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CVDto addCV(CVDto cvDto) {
        return cvService.addCV(cvDto);
    }

    @GetMapping
    public ModelAndView getAllCVs() {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getAllCVs();
        List<PersonDto> persons = personService.getAllPersons();
        List<ContactDataDto> contacts = contactDataService.getAllContactData();
        List<TechnologyDto> technologies = technologyService.getAllTechnologies();
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvList", cvs);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public CVDto getCVById(@PathVariable long id) {
        return cvService.getCVbyId(id);
    }

    @GetMapping(value = "/firstName/{firstName}")
    public List<CVDto> getCVByPersonFirstName(@PathVariable String firstName) {
        return cvService.getCVByPersonFirstName(firstName);
    }

    @GetMapping(value = "/lastName/{lastName}")
    public List<CVDto> getCVByPersonLastName(@PathVariable String lastName) {
        return cvService.getCVByPersonLastName(lastName);
    }

    @GetMapping(value = "/fullName/{firstName}/{lastName}")
    public List<CVDto> getCVByPersonFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return cvService.getCVByPersonFullName(firstName, lastName);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCV(@PathVariable long id, @RequestBody CVDto cvDto) {
        cvService.updateCV(id, cvDto);
    }

    @PutMapping(value = "/addPerson/{personId}/{cvId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CVDto addPersonToCV(@PathVariable long personId, @PathVariable long cvId) {
        return cvService.addPersonToCV(personId, cvId);
    }
}
