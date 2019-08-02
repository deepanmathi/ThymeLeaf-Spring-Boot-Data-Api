package com.springBoot.springData.thymeLeaf.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.springData.thymeLeaf.DAO.EmployeeDAO;
import com.springBoot.springData.thymeLeaf.entity.Employee;
import com.springBoot.springData.thymeLeaf.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO empDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmDao) {
		 this.empDao=theEmDao;
	}

	@Override
	public List<Employee> getAllEmloyees() {
		// TODO Auto-generated method stub
		//return empDao.findAll();
		return empDao.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> optionalFindById = empDao.findById(id);
		Employee emp=null;
		if(optionalFindById.isPresent())
			emp=optionalFindById.get();
		return emp;
	}

	@Override
	public void save(Employee emp) {
		empDao.save(emp);
		
	}

	@Override
	public void delete(int id) {
		empDao.deleteById(id);
		
	}

}
