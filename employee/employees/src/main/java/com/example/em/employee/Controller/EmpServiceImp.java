package com.example.em.employee.Controller;

import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.em.employee.Entity.empEntity;
import com.example.em.employee.Repository.EmpRepository;
import com.example.em.employee.Services.EmpService;


@Service
public class EmpServiceImp implements EmpService{

    @Autowired
    private EmpRepository empRepository;

    @Override
    public ArrayList<Employee> readEmp() {
        ArrayList<empEntity> empList = (ArrayList<empEntity>) empRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>();

        for (empEntity empAaoo : empList) {

            Employee emp = new Employee();
            emp.setId(empAaoo.getId());
            emp.setName(empAaoo.getName());
            emp.setEmail(empAaoo.getEmail());
            emp.setPassword(empAaoo.getPassword());
            emp.setPhone(empAaoo.getPhone());
            
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public String createEmp(Employee employee) {
        empEntity empEntityObj = new empEntity();
        BeanUtils.copyProperties(employee, empEntityObj);
        empRepository.save (empEntityObj);
        //employees.add(employee);
        return "saved successfully";
    }


    @Override
    public boolean deleteEmp(Long id) {
       
        empEntity emp = empRepository.findById(id).get();
        empRepository.delete(emp);
        return true;      
    }

    @Override
    public String updateEmp(Long id, Employee employee) {

        empEntity exeistingEmp = empRepository.findById(id).get();
        exeistingEmp.setName(employee.getName());
        exeistingEmp.setEmail(employee.getEmail());
        exeistingEmp.setPassword(employee.getPassword());
        exeistingEmp.setPhone(employee.getPhone());
        empRepository.save(exeistingEmp);
        
        return "update successfully";
    }

    

}
