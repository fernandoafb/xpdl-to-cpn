//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.15 at 06:18:08 PM EST 
//

package ee.ut.model.xpdl1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}DataType"/>
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}InitialValue" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}Length" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}Description" minOccurs="0"/>
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}ExtendedAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IsArray" default="FALSE">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="TRUE"/>
 *             &lt;enumeration value="FALSE"/>
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
@XmlType(name = "", propOrder = { "dataType", "initialValue", "length",
		"description", "extendedAttributes" })
@XmlRootElement(name = "DataField")
public class DataField {

	@XmlElement(name = "DataType", required = true)
	protected DataType dataType;
	@XmlElement(name = "InitialValue")
	protected String initialValue;
	@XmlElement(name = "Length")
	protected String length;
	@XmlElement(name = "Description")
	protected String description;
	@XmlElement(name = "ExtendedAttributes")
	protected ExtendedAttributes extendedAttributes;
	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NMTOKEN")
	protected String id;
	@XmlAttribute(name = "Name")
	protected String name;
	@XmlAttribute(name = "IsArray")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String isArray;

	/**
	 * Gets the value of the dataType property.
	 * 
	 * @return possible object is {@link DataType }
	 * 
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 * @param value
	 *            allowed object is {@link DataType }
	 * 
	 */
	public void setDataType(DataType value) {
		this.dataType = value;
	}

	/**
	 * Gets the value of the initialValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInitialValue() {
		return initialValue;
	}

	/**
	 * Sets the value of the initialValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInitialValue(String value) {
		this.initialValue = value;
	}

	/**
	 * Gets the value of the length property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Sets the value of the length property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLength(String value) {
		this.length = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the extendedAttributes property.
	 * 
	 * @return possible object is {@link ExtendedAttributes }
	 * 
	 */
	public ExtendedAttributes getExtendedAttributes() {
		return extendedAttributes;
	}

	/**
	 * Sets the value of the extendedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link ExtendedAttributes }
	 * 
	 */
	public void setExtendedAttributes(ExtendedAttributes value) {
		this.extendedAttributes = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the isArray property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIsArray() {
		if (isArray == null) {
			return "FALSE";
		} else {
			return isArray;
		}
	}

	/**
	 * Sets the value of the isArray property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIsArray(String value) {
		this.isArray = value;
	}

}
