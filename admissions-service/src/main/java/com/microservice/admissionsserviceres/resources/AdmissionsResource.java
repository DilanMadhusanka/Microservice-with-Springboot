package com.microservice.admissionsserviceres.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.admissionsserviceres.models.Patient;

@RestController
public class AdmissionsResource {

	public List<Patient> getPatients() {
		List<Patient> patients = Arrays.asList(new Patient("P1", "Rajapaksha", "Sri Lanka"),
				new Patient("P2", "Jack", "America"), new Patient("P3", "Kate", "England"));
		return patients;
	}

	public Patient getPatientById(@PathVariable("Id") String Id) {

	}
}
