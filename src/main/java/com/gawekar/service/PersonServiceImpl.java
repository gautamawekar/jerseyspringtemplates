package com.gawekar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gawekar.entity.Person;

@Service("personService")
public class PersonServiceImpl {
    private JpaTemplate jpaTemplate;

    public PersonServiceImpl() {
    }

    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    public JpaTemplate getJpaTemplate() {
        return this.jpaTemplate;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createPerson(Person p) {
        jpaTemplate.persist(p);
        //jpaTemplate.flush();
    }

    @Transactional(readOnly = true)
    public List<?> findAll() {
        return jpaTemplate.findByNamedQuery("Person.findAll");
        //        Query query = jpaTemplate.getEntityManagerFactory().createEntityManager().createNamedQuery("Person.findAll");
        //        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Person findById(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return (Person) this.jpaTemplate.findByNamedQueryAndNamedParams("Person.findPersonById", params).get(0);
        //return (Person) this.jpaTemplate.findByNamedQuery().get(0);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePerson(int id) {
        Person p = this.findById(id);
        this.jpaTemplate.remove(p);
        //this.jpaTemplate.flush();
    }
}
