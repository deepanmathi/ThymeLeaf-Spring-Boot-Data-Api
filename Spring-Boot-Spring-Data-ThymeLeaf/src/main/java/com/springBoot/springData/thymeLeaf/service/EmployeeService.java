package com.springBoot.springData.thymeLeaf.service;

import java.util.List;

import com.springBoot.springData.thymeLeaf.entity.Employee;


public interface EmployeeService {
	
   public List<Employee> getAllEmloyees();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void delete(int id);
	
	

}
