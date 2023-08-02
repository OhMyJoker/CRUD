package com.example.crud.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository
                .findEmployeeByUsername(employee.getUsername());
        if (employeeOptional.isPresent()){
            throw new IllegalStateException("Username already exists.");
        }
        employeeRepository.save(employee);
    }

    public void deleteStudent(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists){
            throw new IllegalStateException("Employee with Id " + employeeId + " does not exists.");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId,
                               String name, String username) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException(
                "Employee with Id " + employeeId + " does not exists."));


        if (name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)){
            employee.setName(name);
        }

        if (username != null && username.length() > 0 && !Objects.equals(employee.getUsername(), username)) {
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByUsername(username);

            if (employeeOptional.isPresent()) {
                throw new IllegalStateException("Username already taken.");
            }
        }
    }
}
