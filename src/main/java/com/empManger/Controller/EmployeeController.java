package com.empManger.Controller;

import com.empManger.employeeService.EmployeeService;
import com.empManger.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
       private final EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
    List<Employee> employees = this.employeeService.findAll();
    return new ResponseEntity<>(employees, HttpStatus.OK);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id")Long id){
    Employee employee = this.employeeService.findEmployeeById(id);
    return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    Employee addEmp = this.employeeService.addEmployee(employee);
    return new ResponseEntity<>(addEmp,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    Employee updateEmp = this.employeeService.updateEmployee(employee);
    return new ResponseEntity<>(updateEmp,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id")Long id){
    this.employeeService.deleteEmployeeById(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}
