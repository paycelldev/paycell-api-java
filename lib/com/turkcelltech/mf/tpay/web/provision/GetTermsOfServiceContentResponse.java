
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTermsOfServiceContentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTermsOfServiceContentResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="eulaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="termsOfServiceHtmlContentEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termsOfServiceHtmlContentTR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTermsOfServiceContentResponse", propOrder = {
    "eulaId",
    "termsOfServiceHtmlContentEN",
    "termsOfServiceHtmlContentTR"
})
public class GetTermsOfServiceContentResponse
    extends BaseOutput
{

    protected Long eulaId;
    protected String termsOfServiceHtmlContentEN;
    protected String termsOfServiceHtmlContentTR;

    /**
     * Gets the value of the eulaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEulaId() {
        return eulaId;
    }

    /**
     * Sets the value of the eulaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEulaId(Long value) {
        this.eulaId = value;
    }

    /**
     * Gets the value of the termsOfServiceHtmlContentEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsOfServiceHtmlContentEN() {
        return termsOfServiceHtmlContentEN;
    }

    /**
     * Sets the value of the termsOfServiceHtmlContentEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsOfServiceHtmlContentEN(String value) {
        this.termsOfServiceHtmlContentEN = value;
    }

    /**
     * Gets the value of the termsOfServiceHtmlContentTR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermsOfServiceHtmlContentTR() {
        return termsOfServiceHtmlContentTR;
    }

    /**
     * Sets the value of the termsOfServiceHtmlContentTR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermsOfServiceHtmlContentTR(String value) {
        this.termsOfServiceHtmlContentTR = value;
    }

}
