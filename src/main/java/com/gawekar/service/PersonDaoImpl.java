package com.gawekar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gawekar.entity.Person;

@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

    private final DepartmentDao deptDao;

    @Autowired
    PersonDaoImpl(DepartmentDao deptDao) {
        this.deptDao = deptDao;
    }

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
