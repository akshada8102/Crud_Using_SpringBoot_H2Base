package com.example.SpringBootCrud.Controller;

import com.example.SpringBootCrud.Model.Employee;
import com.example.SpringBootCrud.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeService _employeeService;

    @PostMapping
    public ResponseEntity<String> AddEmployees(@RequestBody List<Employee> empData) throws Exception{
        _employeeService.AddEmployee(empData);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(empData);
        System.out.println("EMPLOYEE ADDED ::"+jsonStr);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("{Id}")
    public Optional<Employee> GetEmployee(@PathVariable("Id") Long Id){
        return _employeeService.GetAllEmployee(Id);
    }

    @GetMapping("GetEmployeeData")
    public List<Object[]> GetEmployeeData(){
        List<Object[]> list = _employeeService.GetEmployeeData();
        return list;
    }

    @GetMapping("GetAddressData")
    public List<Object[]> GetAddressData(){
        List<Object[]> list = _employeeService.GetAddressData();
        return list;
    }

    @GetMapping("GetEmployee")
    public List<Object[]> GetEmployee(){
        List<Object[]> list = _employeeService.GetEmployee();
        return list;
    }
}