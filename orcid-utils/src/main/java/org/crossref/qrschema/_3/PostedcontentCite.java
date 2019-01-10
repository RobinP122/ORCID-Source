//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.17 at 03:19:13 PM BST 
//


package org.crossref.qrschema._3;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.crossref.org/qrschema/3.0}title" minOccurs="0"/>
 *         &lt;element ref="{http://www.crossref.org/qrschema/3.0}contributors" minOccurs="0"/>
 *         &lt;element ref="{http://www.crossref.org/qrschema/3.0}year" minOccurs="0"/>
 *         &lt;element ref="{http://www.crossref.org/qrschema/3.0}doi"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fl_count">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
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
@XmlType(name = "", propOrder = {
    "title",
    "contributors",
    "year",
    "doi"
})
@XmlRootElement(name = "postedcontent_cite")
public class PostedcontentCite {

    protected Title title;
    protected Contributors contributors;
    protected Year year;
    @XmlElement(required = true)
    protected Doi doi;
    @XmlAttribute(name = "fl_count")
    protected BigInteger flCount;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link Title }
     *     
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link Title }
     *     
     */
    public void setTitle(Title value) {
        this.title = value;
    }

    /**
     * Gets the value of the contributors property.
     * 
     * @return
     *     possible object is
     *     {@link Contributors }
     *     
     */
    public Contributors getContributors() {
        return contributors;
    }

    /**
     * Sets the value of the contributors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contributors }
     *     
     */
    public void setContributors(Contributors value) {
        this.contributors = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Year }
     *     
     */
    public Year getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Year }
     *     
     */
    public void setYear(Year value) {
        this.year = value;
    }

    /**
     * Gets the value of the doi property.
     * 
     * @return
     *     possible object is
     *     {@link Doi }
     *     
     */
    public Doi getDoi() {
        return doi;
    }

    /**
     * Sets the value of the doi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Doi }
     *     
     */
    public void setDoi(Doi value) {
        this.doi = value;
    }

    /**
     * Gets the value of the flCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFlCount() {
        return flCount;
    }

    /**
     * Sets the value of the flCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFlCount(BigInteger value) {
        this.flCount = value;
    }

}
