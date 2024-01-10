package net.deptuserapp.departmentservice.service.serviceimpl;

import lombok.AllArgsConstructor;
import net.deptuserapp.departmentservice.entity.Department;
import net.deptuserapp.departmentservice.repository.DepartmentRepository;
import net.deptuserapp.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department) {
        departmentRepository.save(department);

        return department;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {

        Optional<Department> department = departmentRepository.findById(departmentId);
        Department result = new Department();
        if (department.isPresent()){
            result = department.get();
            return result;
        } else {
            throw new RuntimeException("Department with id:" + departmentId + " could not be found.");
        }
    }

    @Override
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
