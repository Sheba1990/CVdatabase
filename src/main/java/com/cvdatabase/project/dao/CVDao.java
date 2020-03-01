package com.cvdatabase.project.dao;

import com.cvdatabase.project.api.dao.ICVDao;
import com.cvdatabase.project.entities.*;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class CVDao extends AGenericDao<CV> implements ICVDao {

    public CVDao() {
        super(CV.class);
    }


    public List<CV> getByTechnologyName(String name) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Technology> technology = root.join(CV_.TECHNOLOGIES);
            query.select(root).where(criteriaBuilder.equal(technology.get(Technology_.NAME), name));
            TypedQuery<CV> result = entityManager.createQuery(query);
            System.out.println("The list of CVs with mentioned technology: " + name);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CV> getByFirstName(String firstName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Person> person = root.join(CV_.PERSON);
            query.select(root).where(criteriaBuilder.equal(person.get(Person_.FIRST_NAME), firstName));
            TypedQuery<CV> result = entityManager.createQuery(query);
            System.out.println("The list of CVs with mentioned first name : " + firstName);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CV> getByLastName(String lastName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Person> person = root.join(CV_.PERSON);
            query.select(root).where(criteriaBuilder.equal(person.get(Person_.LAST_NAME), lastName));
            TypedQuery<CV> result = entityManager.createQuery(query);
            System.out.println("The list of CVs with mentioned last name : " + lastName);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
