package com.cvdatabase.project.controllers;

import com.cvdatabase.project.api.services.ICVService;
import com.cvdatabase.project.api.services.IContactDataService;
import com.cvdatabase.project.api.services.IPersonService;
import com.cvdatabase.project.api.services.ITechnologyService;
import com.cvdatabase.project.dto.CVDto;
import com.cvdatabase.project.dto.ContactDataDto;
import com.cvdatabase.project.dto.PersonDto;
import com.cvdatabase.project.dto.TechnologyDto;
import com.cvdatabase.project.entities.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @GetMapping("/new")
    public ModelAndView showNewCVForm() {
        CVDto cvDto = new CVDto();
        PersonDto personDto = new PersonDto();
        ContactDataDto contactDataDto = new ContactDataDto();
        List<TechnologyDto> technologyDtos = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cv", cvDto);
        modelAndView.addObject("person", personDto);
        modelAndView.addObject("contacts", contactDataDto);
        modelAndView.addObject("technologies", technologyDtos);
        modelAndView.setViewName("views/new_cv");
        return modelAndView;
    }

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView addCV(
            CVDto cvDto,
            PersonDto personDto,
            ContactDataDto contactDataDto) {
        ModelAndView modelAndView = new ModelAndView();
        cvService.addCV(cvDto, personDto, contactDataDto);
        modelAndView.setViewName("redirect:/cvs");
        return modelAndView;
    }

    @GetMapping(value = "/edit_cv/{id}")
    public ModelAndView showEditCVFrom(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/edit_cv");
        CVDto cvDto = cvService.getCVbyId(id);
        modelAndView.addObject("cv", cvDto);
        return modelAndView;

    }

    @PostMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView editCV(@PathVariable("id") long id,
                                   CVDto cvDto,
                                   PersonDto personDto,
                                   ContactDataDto contactDataDto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cvs/get_by_id/" + id);
        cvService.updateCV(id, cvDto, personDto, contactDataDto);
        return modelAndView;
    }


    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteCV(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cvs");
        cvService.deleteCV(id);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAllCVs() {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getAllCVs();
        modelAndView.setViewName("/views/cvs");
        modelAndView.addObject("cvs", cvs);
        return modelAndView;
    }

    @GetMapping(value = "/get_by_id/{id}")
    public ModelAndView getCVById(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        CVDto cv = cvService.getCVbyId(id);
        modelAndView.setViewName("views/cv");
        modelAndView.addObject("cv", cv);
        return modelAndView;
    }

    @GetMapping(value = "/first_name/{firstName}")
    public ModelAndView getCVByPersonFirstName(@RequestParam String firstName) {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getCVByPersonFirstName(firstName);
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvs", cvs);
        modelAndView.addObject("firstName", firstName);
        return modelAndView;
    }

    @GetMapping(value = "/last_name/{lastName}")
    public ModelAndView getCVByPersonLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getCVByPersonLastName(lastName);
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvs", cvs);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    @GetMapping(value = "/full_name/{firstName}/{lastName}")
    public List<CVDto> getCVByPersonFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return cvService.getCVByPersonFullName(firstName, lastName);
    }

    @GetMapping(value = "/get_by_technology_name/{name}")
    public ModelAndView getCVByTechnologyName(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getByTechnologyName(name);
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvs", cvs);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @PutMapping(value = "/add_person/{personId}/{cvId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CVDto addPersonToCV(@PathVariable long personId, @PathVariable long cvId) {
        return cvService.addPersonToCV(personId, cvId);
    }

}
