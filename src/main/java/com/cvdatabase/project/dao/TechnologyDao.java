package com.cvdatabase.project.dao;

import com.cvdatabase.project.api.dao.ITechnologyDao;
import com.cvdatabase.project.entities.Technology;
import org.springframework.stereotype.Repository;

@Repository
public class TechnologyDao extends AGenericDao<Technology> implements ITechnologyDao {

    public TechnologyDao() {
        super(Technology.class);
    }
}
