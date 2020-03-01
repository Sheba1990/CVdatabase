package com.cvdatabase.project.dao;

import com.cvdatabase.project.api.dao.IPersonDao;
import com.cvdatabase.project.entities.Person;
import com.cvdatabase.project.entities.metamodels.Person_;
import com.cvdatabase.project.entities.Technology;
import com.cvdatabase.project.entities.metamodels.Technology_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonDao extends AGenericDao<Person> implements IPersonDao {

    public PersonDao() {
        super(Person.class);
    }

    public List<Person> getByFirstName(String firstName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
            Root<Person> root = query.from(Person.class);
            query.select(root).where(criteriaBuilder.equal(root.get(Person_.FIRST_NAME), firstName));
            TypedQuery<Person> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Person> getByLastName(String lastName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
            Root<Person> root = query.from(Person.class);
            query.select(root).where(criteriaBuilder.equal(root.get(Person_.LAST_NAME), lastName));
            TypedQuery<Person> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Person> getByFullName(String firstName, String lastName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
            Root<Person> root = query.from(Person.class);
            query.select(root).where(criteriaBuilder.equal(root.get(Person_.FIRST_NAME), firstName), criteriaBuilder.equal(root.get(Person_.LAST_NAME), lastName));
            TypedQuery<Person> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Person> getByTechnologyName(String technologyName) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
            Root<Person> root = query.from(Person.class);
            Join<Person, Technology> technology = root.join(Person_.TECHNOLOGIES);
            query.select(root).where(criteriaBuilder.equal(technology.get(Technology_.NAME), technologyName));
            TypedQuery<Person> result = entityManager.createQuery(query);
            return result.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
