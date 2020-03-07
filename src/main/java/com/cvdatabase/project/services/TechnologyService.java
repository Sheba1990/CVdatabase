package com.cvdatabase.project.services;

import com.cvdatabase.project.api.dao.ITechnologyDao;
import com.cvdatabase.project.dto.TechnologyDto;
import com.cvdatabase.project.api.services.ITechnologyService;
import com.cvdatabase.project.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechnologyService implements ITechnologyService {

    @Autowired
    ITechnologyDao technologyDao;

    public TechnologyDto addTechnology(TechnologyDto technologyDto) {
        Technology technology = new Technology();
        technology.setName(technologyDto.getName());
        return TechnologyDto.entityToDto(technology);
    }

    public List<TechnologyDto> getAllTechnologies() {
        return TechnologyDto.convertList(technologyDao.getAll());
    }

    public TechnologyDto getTechnologyById(long id) {
        return TechnologyDto.entityToDto(technologyDao.get(id));
    }

    public TechnologyDto getTechnologyByName(String name) {
        return TechnologyDto.entityToDto(technologyDao.getByName(name));
    }

    public void updateTechnology(long id, TechnologyDto technologyDto) {
        Technology technology = technologyDao.get(id);
        if (technologyDto.getName() != null && !StringUtils.isEmpty(technologyDto.getName())) {
            technology.setName(technologyDto.getName());
        }
        technologyDao.update(technology);
    }

    public void deleteTechnology(long id) {
        technologyDao.delete(technologyDao.get(id));
    }
}
