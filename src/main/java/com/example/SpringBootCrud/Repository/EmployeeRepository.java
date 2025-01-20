package com.example.SpringBootCrud.Repository;

import com.example.SpringBootCrud.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT u.empName, u.empAge, p.city, p.addressType FROM Employee u LEFT JOIN Address p ON u.empId = p.employee.empId")
    List<Object[]> GetEmployeeData();

    @Query("SELECT u.empName, u.empAge, p.city, p.addressType FROM Employee u RIGHT JOIN Address p ON u.empId = p.employee.empId")
    List<Object[]> GetAddressData();

    @Query("SELECT u.empName, u.empAge, p.city, p.addressType FROM Employee u INNER JOIN Address p ON u.empId = p.employee.empId")
    List<Object[]> GetEmployee();

}