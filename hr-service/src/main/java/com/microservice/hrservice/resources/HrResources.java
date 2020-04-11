package com.microservice.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hrservice.models.Employee;

@RestController
@RequestMapping("/hr")
public class HrResources {

	List<Employee> employees = Arrays.asList(new Employee("E1", "Kindson", "Munonye", "MediTec"),
			new Employee("E2", "Lila", "Hardcastle", "Surgery"), new Employee("E3", "Solace", "Chucks", "Dentistry"));

	@RequestMapping("/employees")
	public List<Employee> getEmployees() {
		return employees;
	}

	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") String Id) {
		Employee e = employees.stream().filter(employee -> Id.equals(employee.getId())).findAny().orElse(null);
		return e;
	}
}
