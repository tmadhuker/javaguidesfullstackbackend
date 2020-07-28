package com.javaguidesfullstack.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguidesfullstack.backend.exception.ResourceNotFoundException;
import com.javaguidesfullstack.backend.model.Employee;
import com.javaguidesfullstack.backend.repository.EmployeeRepository;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all the employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		
		Employee employee = employeeRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Employee not found with the id "+id));
		return ResponseEntity.ok(employee);
	
	}
	
//	update the existing employee 
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id ,@RequestBody Employee employeeDetails){
		
		Employee employee = employeeRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Employee not found with the id "+id));
 
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getFirstName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
}