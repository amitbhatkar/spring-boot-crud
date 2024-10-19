package com.example.em.employee.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.em.employee.Services.EmpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("http://localhost:5173")
public class empContoller {
    
    @Autowired
    EmpService objEmpService;

    //public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/Images";

    @GetMapping("/emp")
    public ArrayList<Employee> getEmployees(){

        return objEmpService.readEmp();
    }

    @PostMapping("/empp")
    public String addEmployee(@RequestBody Employee employee){

        return objEmpService.createEmp(employee);
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable long id){
        if(objEmpService.deleteEmp(id)){
            return "Delete successfully completed";
        }
        else{
            return "Delete failed";
        }
    }
    

    @PutMapping("update/{id}")
    public String putMethod(@PathVariable Long id, @RequestBody Employee employee) {
        
        return objEmpService.updateEmp(id, employee);
    }
 

    
}

