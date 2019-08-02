package com.springBoot.springData.thymeLeaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.springData.thymeLeaf.entity.Employee;
import com.springBoot.springData.thymeLeaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
  
	private EmployeeService empService;
	
	public EmployeeController(EmployeeService empService)
	{
		this.empService=empService;
	}
	/*//@PostConstruct
	private void loadData()
	{
		Employee emp1=new Employee(0, "Deepan", "Mathialagan", "dmat@email.com");
		Employee emp2=new Employee(1, "Prakash", "Mathialagan", "pramat@email.com");
		Employee emp3=new Employee(2, "meera", "Mathialagan", "meermat@email.com");
		employeesList=new ArrayList<Employee>();
		employeesList.add(emp1);
		employeesList.add(emp2);
		employeesList.add(emp3);
	}*/
	
	@GetMapping("/listEmployees")
	public String listEmployees(Model theModel)
	{   
        List<Employee> employeesList=empService.getAllEmloyees();  
		theModel.addAttribute("theEmployeesList",employeesList);
		return "list-employees";
		
	}
	
	
	@PostMapping("/save")
	public String saveOrUpdateEmployee(@ModelAttribute("employee") Employee theEmployee)
	{
		empService.save(theEmployee);
		return "redirect:/employees/listEmployees"; // /post/redirect/get pattern
	}
	
	@GetMapping("/AddForm")
	public String showForm(Model theModel)
	{
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "add-update-employee"; //html name
	}
	
	@GetMapping("/UpdateForm")
	public String showUpdateForm(@RequestParam("empId") int id, Model theModel)
	{
		Employee theEmployee=empService.findById(id);
		theModel.addAttribute("employee", theEmployee);
		return "add-update-employee";
	}
	
	@GetMapping("/Delete")
	public String delete(@RequestParam("empId") int id)
	{
		empService.delete(id);
		
		return "redirect:/employees/listEmployees";
	}
}
