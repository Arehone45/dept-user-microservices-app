package net.deptuserapp.departmentservice.repository;

import net.deptuserapp.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    void deleteById(Long id);
}
