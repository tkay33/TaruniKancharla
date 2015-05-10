package edu.asu.bmi.cda.rest.service;

import java.util.ArrayList;
import java.util.List;

import edu.asu.bmi.cda.rest.fhirmodel.Patient;

public class PatientService {

	
	public List<Patient> getAllPatients() {
		Patient m1 = new Patient(1L, "Hyperthyroidism", "Taruni", "September 29, 1992");
		Patient m2 = new Patient(2L, "Oral Herpes", "Wesley", "July 18, 1984");
		List<Patient> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	
}