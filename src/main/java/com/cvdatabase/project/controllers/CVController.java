package com.cvdatabase.project.controllers;

import com.cvdatabase.project.api.services.ICVService;
import com.cvdatabase.project.api.services.IContactDataService;
import com.cvdatabase.project.api.services.IPersonService;
import com.cvdatabase.project.api.services.ITechnologyService;
import com.cvdatabase.project.dto.CVDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CVDto addCV(CVDto cvDto) {
        return cvService.addCV(cvDto);
    }

    @GetMapping
    public ModelAndView getAllCVs() {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getAllCVs();
        modelAndView.setViewName("/views/cvs");
        modelAndView.addObject("cvsList", cvs);
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public CVDto getCVById(@PathVariable long id) {
        return cvService.getCVbyId(id);
    }

    @GetMapping(value = "/first_name/{firstName}")
    public ModelAndView getCVByPersonFirstName(@RequestParam String firstName) {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getCVByPersonFirstName(firstName);
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvsList", cvs);
        modelAndView.addObject("firstName", firstName);
        return modelAndView;
    }

    @GetMapping(value = "/last_name/{lastName}")
    public ModelAndView getCVByPersonLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getCVByPersonLastName(lastName);
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvsList", cvs);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    @GetMapping(value = "/full_name/{firstName}/{lastName}")
    public List<CVDto> getCVByPersonFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return cvService.getCVByPersonFullName(firstName, lastName);
    }

    @GetMapping(value = "/technology_name/{name}")
    public ModelAndView hetCVByTechnologyName(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView();
        List<CVDto> cvs = cvService.getByTechnologyName(name);
        modelAndView.setViewName("views/cvs");
        modelAndView.addObject("cvsList", cvs);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCV(@PathVariable long id, @RequestBody CVDto cvDto) {
        cvService.updateCV(id, cvDto);
    }

    @PutMapping(value = "/add_person/{personId}/{cvId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CVDto addPersonToCV(@PathVariable long personId, @PathVariable long cvId) {
        return cvService.addPersonToCV(personId, cvId);
    }
}
