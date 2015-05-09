package edu.asu.bmi.cda.homework6;

public class Diabetes_ontology {

	public static void main(String[] args) throws Exception {
		
		Ontology db = new Ontology();
		db.getOntology();
		
		db.addCodedConcept("Diabetes mellitus", "73211009");
		db.addCodedConcept("Diabetes mellitus type 1", "46635009");
		db.addCodedConcept("Diabetes mellitus type 2", "44054006");
		db.addCodedConcept("Diabetes mellitus due to genetic defect in beta cell function", "609568004");
		db.addCodedConcept("Diabetes mellitus due to genetic defect in insulin action", "609569007");
		db.addCodedConcept("Diabetes mellitus due to pancreatic injury", "105401000119101");
		db.addCodedConcept("Finding site", "363698007");
		db.addCodedConcept("Type I diabetes mellitus with gangrene", "190369008");
		
		//added to bmivocabulary in the method addCodedConcept
		
		db.addObjectProperty("subTypeOf","Diabetes mellitus type 1", "Diabetes mellitus" );
		db.addObjectProperty("subTypeOf","Diabetes mellitus type 2", "Diabetes mellitus" );
		db.addObjectProperty("subTypeOf","Diabetes mellitus due to genetic defect in beta cell function", "Diabetes mellitus" );
		db.addObjectProperty("subTypeOf","Diabetes mellitus due to genetic defect in insulin action", "Diabetes mellitus" );
		db.addObjectProperty("subTypeOf","Diabetes mellitus due to pancreatic injury", "Diabetes mellitus" );
		db.addObjectProperty("subTypeOf","Type I diabetes mellitus with gangrene", "Diabetes mellitus type 1" );
		db.addDataProperty("hasFindingSite", "Diabetes mellitus", "endrocine system" );
		
		db.saveOntology();

	}

}