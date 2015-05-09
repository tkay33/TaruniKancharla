package edu.asu.bmi.cda.Kancharla-4th;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hl7.fhir.model.*;
import org.junit.Test;

public class medicationUnmarshallerTestCase {

	@Test
	public void testMedicationUnmarshaller() throws Exception {
		JAXBContext c = JAXBContext.newInstance( Medication.class.getPackage().getName() );
		Unmarshaller u = c.createUnmarshaller();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("Medication.xml");
		Medication med = (Medication)u.unmarshal( is);
		
		System.out.println(med.getName().getValue());
		System.out.println(med.getIsBrand().isValue());
		System.out.println(med.getKind().getValue());
		System.out.println(med.getCode().getCodings().get(0).getSystem().getValue());
		System.out.println(med.getCode().getCodings().get(0).getCode().getValue());
		System.out.println(med.getCode().getCodings().get(0).getDisplay().getValue());
		System.out.println(med.getProduct().getForm().getCodings().get(0).getSystem().getValue());
		System.out.println(med.getProduct().getForm().getCodings().get(0).getCode().getValue());
		System.out.println(med.getProduct().getForm().getCodings().get(0).getDisplay().getValue());
		
		assertEquals(med.getName().getValue(),"Penicillin VK oral suspension 125mg/5ml");
		assertEquals(med.getIsBrand().isValue(),false);
		assertEquals(med.getKind().getValue(),org.hl7.fhir.model.MedicationKindList.PRODUCT);
		assertEquals(med.getCode().getCodings().get(0).getSystem().getValue(),"http://snomed.info/sct");
		assertEquals(med.getCode().getCodings().get(0).getCode().getValue(),"323418000");
		assertEquals(med.getCode().getCodings().get(0).getDisplay().getValue(),"Phenoxymethylpenicillin 125mg/5mL oral solution (product)");
		assertEquals(med.getProduct().getForm().getCodings().get(0).getSystem().getValue(),"http://snomed.info/sct");
		assertEquals(med.getProduct().getForm().getCodings().get(0).getCode().getValue(),"37595005");
		assertEquals(med.getProduct().getForm().getCodings().get(0).getDisplay().getValue(),"Suspension");
	}

}