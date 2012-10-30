package com.gawekar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gawekar.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao deptDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public Department createDepartmentIfRequired(Department d) {
        Department savedDept = deptDao.findDepartmentById(d.getId());
        if (savedDept == null) {
            System.out.println("Creating new dept");
            Department newDept = new Department();
            newDept.setName(d.getName());
            deptDao.createDepartment(newDept);
            return newDept;
        } else {
            System.out.println("using existing dept");
            return d;
        }
    }

}
