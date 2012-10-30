package com.gawekar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gawekar.entity.Department;
import com.gawekar.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;
    private final DepartmentService deptService;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, DepartmentService deptService) {
        this.personDao = personDao;
        this.deptService = deptService;
    }

    @Override
    public Person createPerson(Person p) {
        Department d = p.getDept();
        Department updatedDept = this.deptService.createDepartmentIfRequired(d);
        p.setDept(updatedDept);
        return personDao.createPerson(p);
    }
}
