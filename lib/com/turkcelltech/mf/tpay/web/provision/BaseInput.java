
package com.turkcelltech.mf.tpay.web.provision;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="extraParameters" type="{http://provision.web.tpay.mf.turkcelltech.com/}extraParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requestHeader" type="{http://provision.web.tpay.mf.turkcelltech.com/}requestHeader" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseInput", propOrder = {
    "extraParameters",
    "requestHeader"
})
@XmlSeeAlso({
    SendOTPRequest.class,
    GetThreeDSessionRequest.class,
    UpdateCardRequest.class,
    RegisterCardRequest.class,
    GetTermsOfServiceContentRequest.class,
    RegisterSubscriberRequest.class,
    GetThreeDSessionResultRequest.class,
    InquireForOilServiceRequest.class,
    ProvisionRequest.class,
    ProvisionForMarketPlaceRequest.class,
    GetProvisionHistoryRequest.class,
    ProvisionForOilServiceRequest.class,
    StartProvisionRequest.class,
    IsAvailableForProvisionRequest.class
})
public class BaseInput {

    @XmlElement(nillable = true)
    protected List<ExtraParameter> extraParameters;
    protected RequestHeader requestHeader;

    /**
     * Gets the value of the extraParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtraParameter }
     * 
     * 
     */
    public List<ExtraParameter> getExtraParameters() {
        if (extraParameters == null) {
            extraParameters = new ArrayList<ExtraParameter>();
        }
        return this.extraParameters;
    }

    /**
     * Gets the value of the requestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    /**
     * Sets the value of the requestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setRequestHeader(RequestHeader value) {
        this.requestHeader = value;
    }

}
