
package com.turkcelltech.mf.tpay.web.provision;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="extraParameters" type="{http://provision.web.tpay.mf.turkcelltech.com/}extraParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="responseHeader" type="{http://provision.web.tpay.mf.turkcelltech.com/}responseHeader" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseOutput", propOrder = {
    "extraParameters",
    "responseHeader"
})
@XmlSeeAlso({
    RegisterSubscriberResponse.class,
    SendOTPResponse.class,
    GetThreeDSessionResultResponse.class,
    IsAvailableForProvisionResponse.class,
    ProvisionForMarketPlaceResponse.class,
    UpdateCardResponse.class,
    GetThreeDSessionResponse.class,
    RegisterCardResponse.class,
    GetCardsResponse.class,
    StartProvisionResponse.class,
    InquireForOilServiceResponse.class,
    GetProvisionHistoryResponse.class,
    GetTermsOfServiceContentResponse.class,
    ProvisionForOilServiceResponse.class,
    ProvisionResponse.class
})
public class BaseOutput {

    @XmlElement(nillable = true)
    protected List<ExtraParameter> extraParameters;
    protected ResponseHeader responseHeader;

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
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
    }

}
