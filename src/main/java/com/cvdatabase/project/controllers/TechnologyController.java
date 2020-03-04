package com.cvdatabase.project.controllers;

import com.cvdatabase.project.dto.TechnologyDto;
import com.cvdatabase.project.api.services.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CRUD
@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    @Autowired
    ITechnologyService technologyService;

    //Create
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TechnologyDto addTechnology(@RequestBody TechnologyDto technologyDto) {
        return technologyService.addTechnology(technologyDto);
    }

    //Read
    @GetMapping
    public List<TechnologyDto> getAllTechnologies() {
        return technologyService.getAllTechnologies();
    }

    @GetMapping(value = "/{id}")
    public TechnologyDto getTechnologyById(@PathVariable long id) {
        return technologyService.getTechnologyById(id);
    }

    //Update
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateTechnology(@PathVariable long id, @RequestBody TechnologyDto technologyDto) {
        technologyService.updateTechnology(id, technologyDto);
    }

    //Delete
    @DeleteMapping(value = "/{id}")
    public void deleteTechnology(@PathVariable long id) {
        technologyService.deleteTechnology(id);
    }
}
