package io.springframework.springbootangularcrudproject.model;

import io.springframework.springbootangularcrudproject.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployee(){
        Employee employee = Employee
                .builder()
                .email("patrick@turntabl.io")
                .firstName("Patrick")
                .lastName("Van Kweku AMos")
                .build();
         employeeRepository.save(employee);
    }



}