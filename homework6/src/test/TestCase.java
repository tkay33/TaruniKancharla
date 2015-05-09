package homework6;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class TestCase {

	static final String BMI591 = "http://edu.asu.bmi/cad591/TaruniKancharla/skos/ext#";
	static final String SKOS = "http://www.w3.org/2004/02/skos/core#";

    
    @Test
	public void testAxiom() throws OWLOntologyCreationException{
    	Ontology db = new Ontology();
    	db.getPopulatedOnt();
		
		assertFalse(db.checkRelationship( BMI591+"Type I diabetes mellitus with gangrene", BMI591+"subTypeOf",BMI591+"Diabetes mellitus"));
		ReasonerHelper reason = new ReasonerHelper();
		reason.makeInferences( db.getPopulatedOnt());
		assertTrue(db.checkRelationship( BMI591+"Type I diabetes mellitus with gangrene", BMI591+"subTypeOf",BMI591+"Diabetes mellitus"));
		
		
	}
		
		

}