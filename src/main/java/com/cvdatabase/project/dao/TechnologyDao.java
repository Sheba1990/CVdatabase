package com.cvdatabase.project.dao;

import com.cvdatabase.project.api.dao.ITechnologyDao;
import com.cvdatabase.project.entities.Technology;
import com.cvdatabase.project.entities.Technology_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TechnologyDao extends AGenericDao<Technology> implements ITechnologyDao {

    public TechnologyDao() {
        super(Technology.class);
    }

    public Technology getByName(String name) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Technology> query = criteriaBuilder.createQuery(Technology.class);
            Root<Technology> root = query.from(Technology.class);
            query.select(root).where(criteriaBuilder.equal(root.get(Technology_.NAME), name));
            TypedQuery<Technology> result = entityManager.createQuery(query);
            return result.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
