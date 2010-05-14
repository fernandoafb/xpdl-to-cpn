package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;

public abstract class BPMNElement extends Element {

	public static final int TASK = 0;
	public static final int GATEWAY = 1;
	public static final int START = 2;
	public static final int END = 3;
	public static final int TRANSITION = 4;
	public static final int INTERMEDIATE_TIMER_EVENT = 5;
	public static final int INTERMEDIATE_MESSAGE_EVENT = 6;
	public static final int BOUND_MESSAGE_EVENT = 7;
	public static final int BOUND_TIMER_EVENT = 8;
	public static final int SUB_PROCESS = 9;
	public static final int SUB_PROCESS_START = 10;
	public static final int SUB_PROCESS_END = 11;
	public static final int SUB_PROCESS_TIMER_EVENT = 12;

	public BPMNElement(CPNProcess cPNProcess) {
		this.cPNProcess = cPNProcess;
	}

	public String getId() {
		return elementId;
	}

	public void setId(String id) {
		elementId = id;
	}

	public void setName(String name) {
		this.elementName = name;
	}
}