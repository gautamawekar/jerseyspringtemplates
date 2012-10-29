package com.gawekar.service;

import java.util.List;

import com.gawekar.entity.Person;

public interface PersonDao {
    Person createPerson(Person p);

    void deletePerson(int id);

    Person findPersonById(int id);

    Person updatePerson(Person p);

    List<Person> findAll();
}
