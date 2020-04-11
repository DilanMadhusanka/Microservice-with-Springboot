package com.mcroser.admissionservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcroser.admissionservice.resources.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionResource {

	List<Patient> patients = Arrays.asList(new Patient("P1", "Rajapaksha", "SriLanka"),
			new Patient("P2", "Jack", "America"), new Patient("P3", "Tom", "England"));

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
