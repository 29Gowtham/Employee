package com.example.demo.Service;

import com.example.demo.entity.Employee;
import java.util.List;
 
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployee(Long id);
}