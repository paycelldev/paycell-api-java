
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for threeDOperationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="threeDOperationResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="threeDResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="threeDResultDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "threeDOperationResult", propOrder = {
    "threeDResult",
    "threeDResultDescription"
})
public class ThreeDOperationResult {

    protected String threeDResult;
    protected String threeDResultDescription;

    /**
     * Gets the value of the threeDResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDResult() {
        return threeDResult;
    }

    /**
     * Sets the value of the threeDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDResult(String value) {
        this.threeDResult = value;
    }

    /**
     * Gets the value of the threeDResultDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDResultDescription() {
        return threeDResultDescription;
    }

    /**
     * Sets the value of the threeDResultDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDResultDescription(String value) {
        this.threeDResultDescription = value;
    }

}
