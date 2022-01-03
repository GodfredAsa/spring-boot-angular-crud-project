package io.springframework.springbootangularcrudproject.repository;

import io.springframework.springbootangularcrudproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
