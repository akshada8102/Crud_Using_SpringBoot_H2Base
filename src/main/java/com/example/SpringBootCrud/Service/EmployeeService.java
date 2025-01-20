package com.example.SpringBootCrud.Service;

import com.example.SpringBootCrud.Model.Employee;
import com.example.SpringBootCrud.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository _employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this._employeeRepository = employeeRepository;
    }

    public void AddEmployee(List<Employee> empData){
        _employeeRepository.saveAll(empData);
    }

    public List<Employee> GetAllEmployees(){
        return _employeeRepository.findAll();
    }

    public List<Object[]> GetEmployeeData() {
        List<Object[]> employeeList = _employeeRepository.GetEmployeeData();
        return  employeeList;
    }

    public List<Object[]> GetAddressData() {
        List<Object[]> addressList = _employeeRepository.GetAddressData();
        return  addressList;
    }

    public List<Object[]> GetEmployee() {
        List<Object[]> employeeList = _employeeRepository.GetEmployee();
        return  employeeList;
    }

}
