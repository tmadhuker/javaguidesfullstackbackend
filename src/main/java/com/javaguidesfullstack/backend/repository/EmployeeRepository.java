package com.javaguidesfullstack.backend.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javaguidesfullstack.backend.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//	public List <Employee> findByFirstName(String firstName);
}
