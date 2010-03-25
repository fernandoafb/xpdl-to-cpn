package ee.ut.model.bpmne;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Code;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Port;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;



public class BPMNeStartEvent {
	private String name;
	private Page page;
	private XmlObject color;
	private XmlObject variable;
	private String counterVar;
	private Trans transition;
	protected Place outputPlace;
	private Place nextCasePlace;

	public BPMNeStartEvent(Page page, String name, XmlObject color, XmlObject variable, XmlObject counterType, String counterVar) {
		this.page = page;
		this.name = name;
		this.color = color;
		this.variable = variable;
		this.counterVar = counterVar;
		
		transition = BPMNeUtil.createTrans(page, name);

		// adds log file initializer to the case generator
		XmlString createCaseFile = XmlString.Factory.newValue("input (caseId);\noutput ();\naction (createCaseFile(caseId));");
		transition.getCodeArray()[0].getText().set(createCaseFile);

		outputPlace = BPMNeUtil.createPlace(page, name + "_new_case");
		outputPlace.getTypeArray()[0].getText().set(color.copy());		
		outputPlace.addNewPort().setType("Out");

		BPMNeUtil.createArc(page, transition, outputPlace, XmlString.Factory.newValue("initCaseInfo("+counterVar+")"));
		
		// --- case generation
		nextCasePlace = BPMNeUtil.createPlace(page, "nextCase");
		nextCasePlace.getTypeArray()[0].getText().set(counterType.copy());
		nextCasePlace.getInitmarkArray(0).getText().set(XmlString.Factory.newValue("1"));
		BPMNeUtil.createArc(page, nextCasePlace, transition, XmlString.Factory.newValue(counterVar));
		BPMNeUtil.createArc(page, transition, nextCasePlace, XmlString.Factory.newValue(counterVar + " + 1"));
	}
	
	public Place getExitPlace() {
		return outputPlace;
	}
	
	public void setNumberOfCases(XmlString number) {
		transition.getCondArray(0).getText().set(number);
	}
	
	public void setTimeExpresion(XmlString expr) {
		transition.getTimeArray(0).getText().set(expr);
	}

}