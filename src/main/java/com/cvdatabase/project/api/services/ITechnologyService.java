package com.cvdatabase.project.api.services;

import com.cvdatabase.project.dto.TechnologyDto;

import java.util.List;

public interface ITechnologyService {

    TechnologyDto addTechnology(TechnologyDto technologyDto);

    public List<TechnologyDto> getAllTechnologies();

    TechnologyDto getTechnologyById(long id);

    TechnologyDto getTechnologyByName(String name);

    void updateTechnology(long id, TechnologyDto technologyDto);

    void deleteTechnology(long id);
}
