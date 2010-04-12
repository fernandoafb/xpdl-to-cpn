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
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Message" type="{http://www.wfmc.org/2008/XPDL2.1}MessageType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}BlockActivity"/>
 *           &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}TransitionRef"/>
 *         &lt;/choice>
 *         &lt;any/>
 *       &lt;/sequence>
 *       &lt;attribute name="FaultName" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "message", "blockActivity", "transitionRef",
		"any" })
@XmlRootElement(name = "WebServiceFaultCatch")
public class WebServiceFaultCatch {

	@XmlElement(name = "Message")
	protected MessageType message;
	@XmlElement(name = "BlockActivity")
	protected BlockActivity blockActivity;
	@XmlElement(name = "TransitionRef")
	protected TransitionRef transitionRef;
	@XmlAnyElement(lax = true)
	protected List<java.lang.Object> any;
	@XmlAttribute(name = "FaultName")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NMTOKEN")
	protected String faultName;
	@XmlAnyAttribute
	private Map<QName, String> otherAttributes = new HashMap<QName, String>();

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link MessageType }
	 * 
	 */
	public MessageType getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link MessageType }
	 * 
	 */
	public void setMessage(MessageType value) {
		this.message = value;
	}

	/**
	 * Gets the value of the blockActivity property.
	 * 
	 * @return possible object is {@link BlockActivity }
	 * 
	 */
	public BlockActivity getBlockActivity() {
		return blockActivity;
	}

	/**
	 * Sets the value of the blockActivity property.
	 * 
	 * @param value
	 *            allowed object is {@link BlockActivity }
	 * 
	 */
	public void setBlockActivity(BlockActivity value) {
		this.blockActivity = value;
	}

	/**
	 * Gets the value of the transitionRef property.
	 * 
	 * @return possible object is {@link TransitionRef }
	 * 
	 */
	public TransitionRef getTransitionRef() {
		return transitionRef;
	}

	/**
	 * Sets the value of the transitionRef property.
	 * 
	 * @param value
	 *            allowed object is {@link TransitionRef }
	 * 
	 */
	public void setTransitionRef(TransitionRef value) {
		this.transitionRef = value;
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
	 * Gets the value of the faultName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFaultName() {
		return faultName;
	}

	/**
	 * Sets the value of the faultName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFaultName(String value) {
		this.faultName = value;
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
