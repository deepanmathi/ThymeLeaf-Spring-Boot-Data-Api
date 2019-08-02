package com.springBoot.springData.thymeLeaf.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.springData.thymeLeaf.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
   public List<Employee> findAllByOrderByLastNameAsc(); //this is custom method to sort
}
