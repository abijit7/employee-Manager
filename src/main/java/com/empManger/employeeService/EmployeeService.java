package com.empManger.employeeService;

import com.empManger.Exception.UserNotFound;
import com.empManger.Repo.EmployeeRepo;
import com.empManger.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAll(){
    return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){

    return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long  id){
    return employeeRepo.findEmployeeById(id).orElseThrow(() ->
            new UserNotFound("user of id " + id + "not found"));
    }

    public void deleteEmployeeById(Long id) {
    employeeRepo.deleteById(id);
    }
}
