package com.example.em.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.em.employee.Entity.empEntity;


@Repository
public interface EmpRepository extends JpaRepository<empEntity, Long> {

    
}
