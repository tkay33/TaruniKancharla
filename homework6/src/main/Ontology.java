package homework6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class Ontology {
	
	static final String BMI591 = "http://edu.asu.bmi/cad591/TaruniKancharla/skos/ext#";
	static final String SKOS = "http://www.w3.org/2004/02/skos/core#";
	static final String BMIVOCAB = "http://edu.asu.bmi/cad591/TaruniKancharla/skos/ext/bmiVocabulary#";
	OWLOntology ontology;
	OWLOntologyManager manager;
	OWLDataFactory factory;
	
	
	public OWLOntology getOntology() throws Exception{

	manager = OWLManager.createOWLOntologyManager();
	ontology = manager.loadOntologyFromOntologyDocument(
			this.getClass().getResourceAsStream( "/test.owl" ));
	factory = manager.getOWLDataFactory();
	return(ontology);
	}
	
	public void addCodedConcept(String name, String code){
		OWLNamedIndividual ind = factory.getOWLNamedIndividual(IRI.create( BMI591 + name ));
		manager.addAxiom( ontology, factory.getOWLDeclarationAxiom( ind ) );
		addObjectProperty(SKOS+"inScheme", BMI591+ name, BMI591+"bmiVocabulary");
		addDataProperty(SKOS+"inScheme", BMI591+ name, code);
	}
	
	public void addObjectProperty(String property, String subject, String object){
	OWLObjectPropertyAssertionAxiom opa = factory.getOWLObjectPropertyAssertionAxiom(
		factory.getOWLObjectProperty( IRI.create(property) ), 
		factory.getOWLNamedIndividual( IRI.create(subject) ),
		factory.getOWLNamedIndividual( IRI.create(object) ));
	manager.addAxiom( ontology, opa );
	}
	
	
	public void addDataProperty(String property,String individual, String value){
		OWLDataPropertyAssertionAxiom oda = factory.getOWLDataPropertyAssertionAxiom(
				factory.getOWLDataProperty( IRI.create(property) ),
				factory.getOWLNamedIndividual( IRI.create(individual) ),
				value);
		manager.addAxiom( ontology, oda );
	}
	
	public void saveOntology() throws OWLOntologyStorageException, OWLOntologyCreationException, FileNotFoundException {
		manager.saveOntology( ontology, System.err );
		manager.saveOntology(ontology, new FileOutputStream("src/sno.owl"));
	}
	
	public OWLOntology getPopulatedOnt() throws OWLOntologyCreationException {
	   	 manager = OWLManager.createOWLOntologyManager();
		        ontology = manager.loadOntologyFromOntologyDocument(
		        		this.getClass().getResourceAsStream( "src/sno.owl" ));
				factory = manager.getOWLDataFactory();
				return ontology;
	   }
	  
	    public boolean checkRelationship( String subject, String predicate, String object ) {

	        OWLNamedIndividual sub = factory.getOWLNamedIndividual( IRI.create( subject ) );
	        OWLNamedIndividual obj = factory.getOWLNamedIndividual( IRI.create( object ) );
	        OWLObjectProperty prp = factory.getOWLObjectProperty( IRI.create( predicate ) );

	        Set<OWLObjectPropertyAssertionAxiom> info = ontology.getObjectPropertyAssertionAxioms( sub );
	        OWLObjectPropertyAssertionAxiom testX = factory.getOWLObjectPropertyAssertionAxiom( prp, sub, obj );
	        return (info.contains(testX )) ;
	    }    
	
}