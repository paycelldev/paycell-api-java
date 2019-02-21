
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isAvailableForProvisionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="isAvailableForProvisionResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="acquirerBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isAvailableForProvisionResponse", propOrder = {
    "acquirerBankCode"
})
public class IsAvailableForProvisionResponse
    extends BaseOutput
{

    protected String acquirerBankCode;

    /**
     * Gets the value of the acquirerBankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerBankCode() {
        return acquirerBankCode;
    }

    /**
     * Sets the value of the acquirerBankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerBankCode(String value) {
        this.acquirerBankCode = value;
    }

}
