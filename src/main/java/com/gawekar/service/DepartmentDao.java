package com.gawekar.service;

import java.util.List;

import com.gawekar.entity.Department;

public interface DepartmentDao {
    Department createDepartment(Department d);

    void deleteDepartment(int id);

    Department findDepartmentById(int id);

    Department updateDepartment(Department d);

    List<Department> findAll();
}
