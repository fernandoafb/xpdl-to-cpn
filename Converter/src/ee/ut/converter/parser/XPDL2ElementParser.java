package ee.ut.converter.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.model.bpmn.BPMNElement;
import ee.ut.model.bpmn.BPMNGateway.GatewayType;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.ActivitySet;
import ee.ut.model.xpdl2.ActivitySets;
import ee.ut.model.xpdl2.BlockActivity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.IntermediateEvent;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Route;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.TransitionRestrictions;
import ee.ut.model.xpdl2.Transitions;

/**
 * @author karl
 * 
 */
public class XPDL2ElementParser implements ElementParser {

	ProcessType xpdlProcess;

	// <Process,<Key,Activity>> - Process to activities mappings.
	protected Map<String, HashMap<String, Activity>> activities = new HashMap<String, HashMap<String, Activity>>();

	// <Activity ID, Process ID> - Activity to process mappings.
	protected Map<String, String> activityToProcess = new HashMap<String, String>();

	// <Transition> - List of all transitions (Boundary events excluded)
	protected ArrayList<Transition> transitions = new ArrayList<Transition>();

	// <Activity,<Next Activities>> - Adjacency list
	protected Map<Activity, List<Activity>> adjList = new HashMap<Activity, List<Activity>>();

	// <Process,<Sink Activities>> - Process to end activities mappings.
	protected HashMap<String, List<Activity>> sinks = new HashMap<String, List<Activity>>();

	// <Process,<Source Activities>> - Process to start activities mappings.
	protected HashMap<String, List<Activity>> sources = new HashMap<String, List<Activity>>();

	// <Event Activity,Target Activity ID> - Event to target activities mappings.
	private HashMap<Activity, String> boundEvents = new HashMap<Activity, String>();

	/**
	 * @param processFile
	 */
	public XPDL2ElementParser(File processFile) {

		JAXBElement<PackageType> xpdlRoot = unMasrhall(processFile,
				"ee.ut.model.xpdl2");

		xpdlProcess = xpdlRoot.getValue().getWorkflowProcesses()
				.getWorkflowProcess().get(0);

		for (Object o : xpdlProcess.getContent()) {
			if (o instanceof Activities) {
				for (Activity a : ((Activities) o).getActivity()) {
					addProcessActivity("0", a);
					ifBoundEventAddTransition(a);
				}
			} else if (o instanceof Transitions) {
				transitions.addAll(((Transitions) o).getTransition());
			} else if (o instanceof ActivitySets) {
				for (ActivitySet aset : ((ActivitySets) o).getActivitySet()) {
					for (Activity a : aset.getActivities().getActivity()) {
						addProcessActivity(aset.getId(), a);
						ifBoundEventAddTransition(a);
					}
					transitions.addAll(aset.getTransitions().getTransition());
				}
			}
		}

		// Build adjacency list
		for (Transition t : transitions) {
			addEdge(activities.get(activityToProcess.get(t.getFrom())).get(
					t.getFrom()), activities.get(
					activityToProcess.get(t.getTo())).get(t.getTo()));
		}

		// Add bounded events to the adjacency list. This is done separately
		// because there is no transition between boundary events.
		for (Activity event : boundEvents.keySet()) {
			String process = activityToProcess.get(boundEvents.get(event));
			Activity target = activities.get(process).get(
					boundEvents.get(event));
			addEdge(target, event);
			// DEBUG
			System.out.println("Found boundary event: " + event.getId() + " ("
					+ event.getName() + ")");
			// DEBUG END
		}

		findSinks();
		findSources();

		// DEBUG
		printAdjList();
		// DEBUG END
	}

	/**
	 * @param v1
	 *            Edge from
	 * @param v2
	 *            Edge to
	 */
	private void addEdge(Activity v1, Activity v2) {
		if (!adjList.containsKey(v1)) {
			adjList.put(v1, new LinkedList<Activity>());
		}

		if (!adjList.containsKey(v2)) {
			adjList.put(v2, new LinkedList<Activity>());
		}

		adjList.get(v1).add(v2);

	}

	/**
	 * 
	 */
	private void findSinks() {
		for (String process : activities.keySet()) {
			HashMap<String, Activity> aSet = activities.get(process);
			for (Activity a : aSet.values()) {
				if (adjList.get(a).isEmpty()) {
					addSink(process, a);
				}
			}
		}

		// DEBUG
		System.out.print("Sinks: ");
		for (String process : sinks.keySet()) {
			for (Activity a : sinks.get(process)) {
				System.out.print(a.getName() + ", ");
			}
		}
		System.out.println();
		// DEBUG END
	}

	/**
	 * 
	 */
	private void findSources() {
		for (String process : activities.keySet()) {
			List<Activity> targets = new ArrayList<Activity>();
			List<Activity> sources = new ArrayList<Activity>();

			HashMap<String, Activity> aSet = activities.get(process);
			for (Activity a : aSet.values()) {
				sources.add(a);
				for (Activity t : adjList.get(a)) {
					targets.add(t);
				}
			}
			sources.removeAll(targets);
			addSource(process, sources);

		}

		// DEBUG
		System.out.print("Sources: ");
		for (String process : sources.keySet()) {
			for (Activity a : sources.get(process)) {
				System.out.print(a.getName() + ", ");
			}
		}
		System.out.println();
		// DEBUG END
	}

	/**
	 * @param processId
	 * @param a
	 */
	private void addProcessActivity(String processId, Activity a) {
		if (activities.get(processId) == null)
			activities.put(processId, new HashMap<String, Activity>());

		activities.get(processId).put(a.getId(), a);
		activityToProcess.put(a.getId(), processId);
	}

	/**
	 * @param processId
	 * @param a
	 */
	private void addSink(String processId, Activity a) {
		if (sinks.get(processId) == null)
			sinks.put(processId, new LinkedList<Activity>());
		sinks.get(processId).add(a);
	}

	/**
	 * @param processId
	 * @param s
	 */
	private void addSource(String processId, List<Activity> s) {
		if (sources.get(processId) == null)
			sources.put(processId, new LinkedList<Activity>());
		sources.get(processId).addAll(s);
	}

	/**
	 * @param a
	 */
	private void ifBoundEventAddTransition(Activity a) {
		for (Object c : a.getContent()) {
			if (c instanceof Event) {
				IntermediateEvent ie = ((Event) c).getIntermediateEvent();
				if (ie != null && ie.getTarget() != null) {
					boundEvents.put(a, ie.getTarget());
					//DEBUG
					System.out.println("FOUND BOUNDARY EVENT: " + a.getName());
					//DEBUG END
				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ee.ut.converter.parser.ElementParser#getId(java.lang.Object)
	 */
	@Override
	public String getId(Object o) {
		if (o instanceof Activity) {
			return ((Activity) o).getId();
		} else if (o instanceof Transition) {
			return ((Transition) o).getId();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getElementType(java.lang.Object)
	 */
	public int getElementType(Object element) {
		Activity activity = (Activity) element;
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof BlockActivity) {
				return BPMNElement.SUB_PROCESS;
			}
			if (aContent instanceof Event) {
				if (((Event) aContent).getStartEvent() != null) {
					return BPMNElement.START;
				} else if (((Event) aContent).getEndEvent() != null) {
					return BPMNElement.END;
				} else if (((Event) aContent).getIntermediateEvent() != null) {
					String target = ((Event) aContent).getIntermediateEvent()
							.getTarget();
					if (target != null && target.length() > 0) {
						String trigger = ((Event) aContent)
								.getIntermediateEvent().getTrigger();
						String process = activityToProcess.get(boundEvents.get(activity));
						Activity targetActivity = activities.get(process).get(
								boundEvents.get(activity));
						if (trigger.equals("Timer")) {
							if(getElementType(targetActivity) == BPMNElement.SUB_PROCESS){
								return BPMNElement.SUB_PROCESS_TIMER_EVENT;
							} else {
								return BPMNElement.BOUND_TIMER_EVENT;
							}							
						} else if (trigger.equals("Error")) {
							if(getElementType(targetActivity) == BPMNElement.SUB_PROCESS){
								return BPMNElement.SUB_PROCESS_EXCEPTION;
							} 							
						} else {
							return BPMNElement.BOUND_MESSAGE_EVENT;
						}
					} else {
						String trigger = ((Event) aContent).getIntermediateEvent().getTrigger();
						if (trigger.equals("Timer")) {
							return BPMNElement.INTERMEDIATE_TIMER_EVENT;
						} else if (trigger.equals("Error")) {
							return BPMNElement.THROW_EXCEPTION;
						} else {
							return BPMNElement.INTERMEDIATE_MESSAGE_EVENT;
						}
					}

				}
			} else if (aContent instanceof Route) {
				if (((Route) aContent).getGatewayType().equals("Exclusive")) {
					if (isSplit(activity)) {
						return BPMNElement.GATEWAY;
					} else {
						return BPMNElement.GATEWAY;
					}
				} else if (((Route) aContent).getGatewayType().equals(
						"Inclusive")) {
					if (isSplit(activity)) {
						return BPMNElement.GATEWAY;
					} else {
						return BPMNElement.GATEWAY;
					}
				}

			}
		}
		return BPMNElement.TASK;
	}

	/**
	 * We assume that only split activity has transition restrictions. So this
	 * method determines whether the activity is split or join based on the
	 * existence of transistionrestriction elements
	 * 
	 * @param activity
	 * @return
	 */
	private static boolean isSplit(Activity activity) {
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof TransitionRestrictions) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getTransitionFrom(java.lang.Object)
	 */
	@Override
	public String getTransitionFrom(Object object) {
		return ((Transition) object).getFrom();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getTransitionTo(java.lang.Object)
	 */
	@Override
	public String getTransitionTo(Object object) {
		return ((Transition) object).getTo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getGatewayType(java.lang.Object)
	 */
	@Override
	public GatewayType getGatewayType(Object obj) {
		String type = ((Route) ((Activity) obj).getContent().get(0))
				.getGatewayType();

		if (type.equals("Exclusive")) {
			return GatewayType.EXCLUSIVE;
		} else if (type.equals("Inclusive")) {
			return GatewayType.INCLUSIVE;
		} else {
			System.err.println("Gateway type: " + type + " not implemented.");
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ee.ut.converter.parser.ElementParser#getName(java.lang.Object)
	 */
	@Override
	public String getName(Object o) {
		if (o instanceof Activity) {
			return ((Activity) o).getName();
		}
		return null;
	}

	/**
	 * @param file
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected JAXBElement<PackageType> unMasrhall(File file, String model) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(model);

			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement) u.unmarshal(file);
			return rootElement;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getBoundaryEventTaskId(java.lang
	 * .Object)
	 */
	@Override
	public String getBoundaryEventTaskId(Object obj) {
		return boundEvents.get(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ee.ut.converter.parser.ElementParser#getEventTimer(java.lang.Object)
	 */
	@Override
	public int getEventTimer(Object obj) {
		String timer = ((Event) ((Activity) obj).getContent().get(0))
				.getIntermediateEvent().getTriggerTimer().getTimeDate()
				.getContent().get(0).toString();
		return Integer.valueOf(timer).intValue();
	}

	/*
	 * Method returns the list of all the connected elements.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getNextElements(java.lang.Object)
	 */
	@Override
	public ArrayList<Object> getNextElements(Object element) {
		ArrayList<Object> nextElems = new ArrayList<Object>();

		if (adjList.get(element) != null) {
			nextElems.addAll(adjList.get(element));
		}
		nextElems.addAll(getBoundElements((Activity) element));

		return nextElems;
	}

	/**
	 * @param element
	 * @return
	 */
	private ArrayList<Object> getBoundElements(Activity element) {
		ArrayList<Object> nextElems = new ArrayList<Object>();
		return nextElems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ee.ut.converter.parser.ElementParser#getSource(java.lang.String)
	 */
	@Override
	public Object getSource(String process) {
		// We currently support only one start event
		return sources.get(process).get(0);
	}

	/**
	 * 
	 */
	public void printAdjList() {
		System.out.println("===== XPDL ADJACENY LIST =====");
		System.out.println("===== SIZE: " + adjList.size() + " =====");
		for (Activity e : adjList.keySet()) {
			System.out.print(e.getId() + " --> ");
			for (Activity e2 : adjList.get(e)) {
				System.out.print(e2.getId() + ",");
			}
			System.out.println();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getSubprocessId(java.lang.Object)
	 */
	@Override
	public String getSubprocessId(Object o) {
		for (Object aContent : ((Activity) o).getContent()) {
			if (aContent instanceof BlockActivity) {
				return ((BlockActivity) aContent).getActivitySetId();
			}
		}
		return null;
	}

	@Override
	public String getXorGWOutputIdentifier(String id, String id2) {
		for(Transition t: transitions){
			if(t.getFrom().equals(id) && t.getTo().equals(id2))
				return t.getId();
		}
		return null;
	}

}