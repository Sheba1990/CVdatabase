package com.cvdatabase.project.dao;

import com.cvdatabase.project.api.dao.ICVDao;
import com.cvdatabase.project.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CVDao extends AGenericDao<CV> implements ICVDao {

    public CVDao() {
        super(CV.class);
    }

    public List<CV> getCVByTechnologyName(String name) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Person> person = root.join(CV_.PERSON);
            Join<Person, Technology> technology = person.join(Person_.TECHNOLOGIES);
            List<Predicate> conditions = new ArrayList<>();
            conditions.add(criteriaBuilder.equal(technology.get(Technology_.name), name));
            query.select(root).where(conditions.toArray(new Predicate[] {}));
            TypedQuery<CV> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CV> getCVByPersonFirstName(String firstName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Person> personJoin = root.join(CV_.PERSON);
            query.select(root).where(criteriaBuilder.equal(personJoin.get(Person_.FIRST_NAME), firstName));
            TypedQuery<CV> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CV> getCVByPersonLastName(String lastName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Person> personJoin = root.join(CV_.PERSON);
            query.select(root).where(criteriaBuilder.equal(personJoin.get(Person_.LAST_NAME), lastName));
            TypedQuery<CV> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CV> getCVByPersonFullName(String firstName, String lastName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CV> query = criteriaBuilder.createQuery(CV.class);
            Root<CV> root = query.from(CV.class);
            Join<CV, Person> personJoin = root.join(CV_.PERSON);
            Predicate predicateForFirstName = criteriaBuilder.equal(root.get(Person_.FIRST_NAME), firstName);
            Predicate predicateForLastName = criteriaBuilder.equal(root.get(Person_.LAST_NAME), lastName);
            Predicate predicateForFullName = criteriaBuilder.and(predicateForFirstName, predicateForLastName);
            query.select(root).where(predicateForFullName);
            TypedQuery<CV> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
