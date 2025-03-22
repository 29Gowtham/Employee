package com.example.demo.Service;

import com.example.demo.entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		log.info("Fetching all employees");
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		log.info("Fetching employee with ID: {}", id);
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	@Override
	public Employee addEmployee(Employee employee) {
		log.info("Adding new employee: {}", employee.getName());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		log.info("Updating employee with ID: {}", id);
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		employee.setName(updatedEmployee.getName());
		employee.setEmail(updatedEmployee.getEmail());
		employee.setDepartment(updatedEmployee.getDepartment());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		log.info("Deleting employee with ID: {}", id);
		employeeRepository.deleteById(id);
	}
}
