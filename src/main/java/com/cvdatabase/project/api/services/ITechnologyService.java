package com.cvdatabase.project.api.services;

import com.cvdatabase.project.api.dto.TechnologyDto;

import java.util.List;

public interface ITechnologyService {

    TechnologyDto addTechnology(TechnologyDto technologyDto);

    public List<TechnologyDto> getAllTechnologies();

    TechnologyDto getTechnologyById(long id);

    void updateTechnology(long id, TechnologyDto technologyDto);

    void deleteTechnology(long id);
}
