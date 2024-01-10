package net.deptuserapp.departmentservice.service;

import net.deptuserapp.departmentservice.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    Department addDepartment(Department department);
    Department getDepartmentById(Long departmentId);
    List<Department> getAllDepartments();
    void deleteById(Long id);
}
