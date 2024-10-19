package com.example.em.employee.Services;

import java.util.ArrayList; 
import com.example.em.employee.Controller.Employee;


public interface EmpService {
    
    String createEmp(Employee employee);
    ArrayList<Employee> readEmp();
    boolean deleteEmp(Long id);
    String updateEmp(Long id, Employee employee);

}
