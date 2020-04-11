package com.mcroser.admissionservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mcroser.admissionservice.resources.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {
	
	@Autowired
	private RestTemplate restTemplate;

	List<Patient> patients = Arrays.asList(new Patient("P1", "Rajapaksha", "SriLanka"),
			new Patient("P2", "Jack", "America"), new Patient("P3", "Tom", "England"));
	
	public EmployeeList getPhysicians() {
		EmployeeList employeesList = restTemplate.getForEntity("http://localhost/hr/employees", EmployeeList.class);
	}

	@RequestMapping("/patients")
	public List<Patient> getPatient() {
		return patients;
	}

	@RequestMapping("/patients/{Id}")
	public Patient getPatientById(@PathVariable("Id") String Id) {
		Patient p = patients.stream().filter(patient -> Id.equals(patient.getId())).findAny().orElse(null);
		return p;
	}
}
