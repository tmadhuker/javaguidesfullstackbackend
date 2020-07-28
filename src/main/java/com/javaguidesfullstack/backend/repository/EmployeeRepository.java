package com.javaguidesfullstack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javaguidesfullstack.backend.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
