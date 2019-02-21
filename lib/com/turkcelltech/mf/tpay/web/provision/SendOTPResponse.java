
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendOTPResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendOTPResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="otpValidationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regEx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendOTPResponse", propOrder = {
    "otpValidationId",
    "regEx"
})
public class SendOTPResponse
    extends BaseOutput
{

    protected String otpValidationId;
    protected String regEx;

    /**
     * Gets the value of the otpValidationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtpValidationId() {
        return otpValidationId;
    }

    /**
     * Sets the value of the otpValidationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtpValidationId(String value) {
        this.otpValidationId = value;
    }

    /**
     * Gets the value of the regEx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegEx() {
        return regEx;
    }

    /**
     * Sets the value of the regEx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegEx(String value) {
        this.regEx = value;
    }

}
