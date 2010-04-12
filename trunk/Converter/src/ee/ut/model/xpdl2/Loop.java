//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.15 at 06:18:08 PM EST 
//

package ee.ut.model.xpdl2;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

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
 *       &lt;choice>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}LoopStandard"/>
 *         &lt;element ref="{http://www.wfmc.org/2008/XPDL2.1}LoopMultiInstance"/>
 *       &lt;/choice>
 *       &lt;attribute name="LoopType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Standard"/>
 *             &lt;enumeration value="MultiInstance"/>
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
@XmlType(name = "", propOrder = { "loopStandard", "loopMultiInstance" })
@XmlRootElement(name = "Loop")
public class Loop {

	@XmlElement(name = "LoopStandard")
	protected LoopStandard loopStandard;
	@XmlElement(name = "LoopMultiInstance")
	protected LoopMultiInstance loopMultiInstance;
	@XmlAttribute(name = "LoopType", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String loopType;
	@XmlAnyAttribute
	private Map<QName, String> otherAttributes = new HashMap<QName, String>();

	/**
	 * Gets the value of the loopStandard property.
	 * 
	 * @return possible object is {@link LoopStandard }
	 * 
	 */
	public LoopStandard getLoopStandard() {
		return loopStandard;
	}

	/**
	 * Sets the value of the loopStandard property.
	 * 
	 * @param value
	 *            allowed object is {@link LoopStandard }
	 * 
	 */
	public void setLoopStandard(LoopStandard value) {
		this.loopStandard = value;
	}

	/**
	 * Gets the value of the loopMultiInstance property.
	 * 
	 * @return possible object is {@link LoopMultiInstance }
	 * 
	 */
	public LoopMultiInstance getLoopMultiInstance() {
		return loopMultiInstance;
	}

	/**
	 * Sets the value of the loopMultiInstance property.
	 * 
	 * @param value
	 *            allowed object is {@link LoopMultiInstance }
	 * 
	 */
	public void setLoopMultiInstance(LoopMultiInstance value) {
		this.loopMultiInstance = value;
	}

	/**
	 * Gets the value of the loopType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLoopType() {
		return loopType;
	}

	/**
	 * Sets the value of the loopType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLoopType(String value) {
		this.loopType = value;
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
