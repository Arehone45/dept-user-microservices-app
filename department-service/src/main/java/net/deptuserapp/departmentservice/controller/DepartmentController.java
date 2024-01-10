package net.deptuserapp.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.deptuserapp.departmentservice.entity.Department;
import net.deptuserapp.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department-app")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){

        Department savedDept = departmentService.addDepartment(department);

        return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
    }

    @GetMapping("getDepartmentById/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("deptId") Long departmentId){

        Department department = departmentService.getDepartmentById(departmentId);

        return ResponseEntity.ok(department);
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getAllDept(){

        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        departmentService.deleteById(id);

        return ResponseEntity.ok("Department with ID: " + id + "has been deleted on the database.");
    }

}
