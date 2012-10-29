package com.gawekar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gawekar.entity.Person;

@Service("personDao")
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Person createPerson(Person p) {
        return super.create(p);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void deletePerson(int id) {
        super.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Person findPersonById(int id) {
        return super.find(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Person updatePerson(Person p) {
        return super.update(p);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) super.findByNamedQuery("Person.findAll", null);
    }
}
