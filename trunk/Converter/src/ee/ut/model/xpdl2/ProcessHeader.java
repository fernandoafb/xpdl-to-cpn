//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.15 at 06:18:08 PM EST 
//

package ee.ut.model.xpdl2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Created" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Description" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Priority" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}Limit" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}ValidFrom" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}ValidTo" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}TimeEstimation" minOccurs="0"/>
 *         &lt;any/>
 *       &lt;/sequence>
 *       &lt;attribute name="DurationUnit">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Y"/>
 *             &lt;enumeration value="M"/>
 *             &lt;enumeration value="D"/>
 *             &lt;enumeration value="h"/>
 *             &lt;enumeration value="m"/>
 *             &lt;enumeration value="s"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "created", "description", "priority",
		"limit", "validFrom", "validTo", "timeEstimation", "any" })
@XmlRootElement(name = "ProcessHeader")
public class ProcessHeader {

	@XmlElement(name = "Created")
	protected Created created;
	@XmlElement(name = "Description")
	protected Description description;
	@XmlElement(name = "Priority")
	protected Priority priority;
	@XmlElement(name = "Limit")
	protected Limit limit;
	@XmlElement(name = "ValidFrom")
	protected ValidFrom validFrom;
	@XmlElement(name = "ValidTo")
	protected ValidTo validTo;
	@XmlElement(name = "TimeEstimation")
	protected TimeEstimation timeEstimation;
	@XmlAnyElement(lax = true)
	protected List<java.lang.Object> any;
	@XmlAttribute(name = "DurationUnit")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String durationUnit;
	@XmlAnyAttribute
	private Map<QName, String> otherAttributes = new HashMap<QName, String>();

	/**
	 * Gets the value of the created property.
	 * 
	 * @return possible object is {@link Created }
	 * 
	 */
	public Created getCreated() {
		return created;
	}

	/**
	 * Sets the value of the created property.
	 * 
	 * @param value
	 *            allowed object is {@link Created }
	 * 
	 */
	public void setCreated(Created value) {
		this.created = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link Description }
	 * 
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link Description }
	 * 
	 */
	public void setDescription(Description value) {
		this.description = value;
	}

	/**
	 * Gets the value of the priority property.
	 * 
	 * @return possible object is {@link Priority }
	 * 
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 * 
	 * @param value
	 *            allowed object is {@link Priority }
	 * 
	 */
	public void setPriority(Priority value) {
		this.priority = value;
	}

	/**
	 * Gets the value of the limit property.
	 * 
	 * @return possible object is {@link Limit }
	 * 
	 */
	public Limit getLimit() {
		return limit;
	}

	/**
	 * Sets the value of the limit property.
	 * 
	 * @param value
	 *            allowed object is {@link Limit }
	 * 
	 */
	public void setLimit(Limit value) {
		this.limit = value;
	}

	/**
	 * Gets the value of the validFrom property.
	 * 
	 * @return possible object is {@link ValidFrom }
	 * 
	 */
	public ValidFrom getValidFrom() {
		return validFrom;
	}

	/**
	 * Sets the value of the validFrom property.
	 * 
	 * @param value
	 *            allowed object is {@link ValidFrom }
	 * 
	 */
	public void setValidFrom(ValidFrom value) {
		this.validFrom = value;
	}

	/**
	 * Gets the value of the validTo property.
	 * 
	 * @return possible object is {@link ValidTo }
	 * 
	 */
	public ValidTo getValidTo() {
		return validTo;
	}

	/**
	 * Sets the value of the validTo property.
	 * 
	 * @param value
	 *            allowed object is {@link ValidTo }
	 * 
	 */
	public void setValidTo(ValidTo value) {
		this.validTo = value;
	}

	/**
	 * Gets the value of the timeEstimation property.
	 * 
	 * @return possible object is {@link TimeEstimation }
	 * 
	 */
	public TimeEstimation getTimeEstimation() {
		return timeEstimation;
	}

	/**
	 * Sets the value of the timeEstimation property.
	 * 
	 * @param value
	 *            allowed object is {@link TimeEstimation }
	 * 
	 */
	public void setTimeEstimation(TimeEstimation value) {
		this.timeEstimation = value;
	}

	/**
	 * Gets the value of the any property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the any property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAny().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Element }
	 * {@link java.lang.Object }
	 * 
	 * 
	 */
	public List<java.lang.Object> getAny() {
		if (any == null) {
			any = new ArrayList<java.lang.Object>();
		}
		return this.any;
	}

	/**
	 * Gets the value of the durationUnit property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDurationUnit() {
		return durationUnit;
	}

	/**
	 * Sets the value of the durationUnit property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDurationUnit(String value) {
		this.durationUnit = value;
	}

	/**
	 * Gets a map that contains attributes that aren't bound to any typed
	 * property on this class.
	 * 
	 * <p>
	 * the map is keyed by the name of the attribute and the value is the string
	 * value of the attribute.
	 * 
	 * the map returned by this method is live, and you can add new attribute by
	 * updating the map directly. Because of this design, there's no setter.
	 * 
	 * 
	 * @return always non-null
	 */
	public Map<QName, String> getOtherAttributes() {
		return otherAttributes;
	}

}
