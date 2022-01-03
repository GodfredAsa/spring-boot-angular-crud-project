package io.springframework.springbootangularcrudproject.controllers;

import io.springframework.springbootangularcrudproject.model.Employee;
import io.springframework.springbootangularcrudproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

//    find all
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

//    find by Id
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id){
            return Optional.of(employeeRepository.findById(id).get());
    }

    //    save employee
    @PostMapping("/employees/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //    update employee  => "/employees/{id}/update"
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, Employee newEmployee){
        employeeRepository.getById(employee.getId());
        employee.setEmail(newEmployee.getEmail());
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        return  employeeRepository.save(newEmployee);
    }



    @GetMapping("/employees/number")
    public int getNumberOfEmployees(){
       return (int) getAllEmployees()
               .stream()
               .count();
    }
///employees/{id}/delete"
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeRepository.deleteById(id);

    }



}
