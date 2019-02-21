
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getThreeDSessionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getThreeDSessionResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="threeDSessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getThreeDSessionResponse", propOrder = {
    "threeDSessionId"
})
public class GetThreeDSessionResponse
    extends BaseOutput
{

    protected String threeDSessionId;

    /**
     * Gets the value of the threeDSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSessionId() {
        return threeDSessionId;
    }

    /**
     * Sets the value of the threeDSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSessionId(String value) {
        this.threeDSessionId = value;
    }

}
