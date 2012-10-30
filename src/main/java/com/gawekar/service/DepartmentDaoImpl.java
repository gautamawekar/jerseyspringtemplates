package com.gawekar.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gawekar.entity.Department;

@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Department createDepartment(Department d) {
        return super.create(d);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void deleteDepartment(int id) {
        super.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Department findDepartmentById(int id) {
        return super.find(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Department updateDepartment(Department d) {
        return super.update(d);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Department> findAll() {
        return (List<Department>) super.findByNamedQuery("Department.findall", null);
    }

}
