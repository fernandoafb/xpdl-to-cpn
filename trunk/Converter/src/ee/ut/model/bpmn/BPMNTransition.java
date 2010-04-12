package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.model.xpdl2.Transition;

public class BPMNTransition extends BPMNElement {

	public BPMNTransition(CPNProcess cPNProcess, Transition t) {
		super(cPNProcess);

		Trans trans = cPNProcess.getCpnet().addTrans();

		String transId = trans.getId();

		Place toPlace = null;
		Place fromPlace = null;

		Object objectFrom = cPNProcess.getElement(t.getFrom());
		Object objectTo = cPNProcess.getElement(t.getTo());

		if (objectFrom instanceof BPMNTask) {
			fromPlace = ((BPMNTask) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNGateway) {
			fromPlace = ((BPMNGateway) objectFrom).makeOutputPlace();
		}

		if (objectTo instanceof BPMNTask) {
			toPlace = ((BPMNTask) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNGateway) {
			toPlace = ((BPMNGateway) objectTo).makeInputPlace();
		}

		cPNProcess.getCpnet().addArc(fromPlace.getId(), transId);
		cPNProcess.getCpnet().addArc(transId, toPlace.getId());
	}

}