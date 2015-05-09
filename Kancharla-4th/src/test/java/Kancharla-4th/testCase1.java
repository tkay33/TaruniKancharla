package edu.asu.bmi.cda.Kancharla-4th;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hl7.fhir.model.*;
import org.hl7.fhir.model.Boolean;
import org.hl7.fhir.model.String;
import org.junit.Test;
public class testCase1 {

	@Test
	public void testPatient() throws ParseException{
		@SuppressWarnings("unused")
		DateTime dateTime = new DateTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = sdf.parse("09/29/1992 05:30");
		dateTime.setValue(date);
		
		CodeableConcept genderConcept = new CodeableConcept();
		String gender = new String();
		gender.setValue("female");
		Coding code = new Coding();
		code.setDisplay(gender);
		genderConcept.getCodings().add(code);
		
		Boolean flag = new Boolean();
		flag.setValue(false);
		
	
		CodeableConcept maritalStatusConcept = new CodeableConcept();
		String ms = new String();
		ms.setValue("single");
		Coding marital = new Coding();
		marital.setDisplay(ms);
		maritalStatusConcept.getCodings().add(marital);
		
		String id = new String();
		id.setValue("123456789");
		Identifier pID = new Identifier();
		pID.setValue(id);
		
		//relationship between patient and immunization resource; using reference 
		Immunization immunizationConcept = new Immunization();
		String immunizationID = new String();
		immunizationID.setValue("564738290");
		Identifier immID = new Identifier();
		immID.setValue(immunizationID);
		ResourceReference pImm = new ResourceReference();
		String RR = new String();
		rr.setValue("123456789");
		pImm.setReference(RR);
		immunizationConcept.setSubject(pImm);
		
		Patient patient = new Patient();
		patient.setBirthDate(dateTime);
		patient.setGender(genderConcept);
		patient.setMaritalStatus(maritalStatusConcept);
		patient.setDeceasedBoolean(flag);
		patient.getIdentifiers().add(pID);
		
		assertEquals(patient.getIdentifiers().get(0).getValue().getValue(),"123456789");
		assertEquals(patient.getBirthDate().getValue(),date);
		assertEquals(patient.getGender(), genderConcept);
		assertEquals(patient.getDeceasedBoolean().isValue(),false);
		assertEquals(patient.getMaritalStatus(), maritalStatusConcept);
		
		
	}

}