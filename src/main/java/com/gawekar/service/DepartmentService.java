package com.gawekar.service;

import com.gawekar.entity.Department;

public interface DepartmentService {
    Department createDepartmentIfRequired(Department d);
}
