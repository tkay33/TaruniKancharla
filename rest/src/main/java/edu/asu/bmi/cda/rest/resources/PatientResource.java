package edu.asu.bmi.cda.rest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.asu.bmi.cda.rest.fhirmodel.Patient;
import edu.asu.bmi.cda.rest.service.PatientService;

@Path("/patients")
public class PatientResource {

PatientService patientService = new PatientService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Patient> getPatients() {
		return patientService.getAllPatients();
	}
	
}