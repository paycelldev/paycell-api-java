
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getThreeDSessionResultResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getThreeDSessionResultResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="currentStep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="threeDOperationResult" type="{http://provision.web.tpay.mf.turkcelltech.com/}threeDOperationResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getThreeDSessionResultResponse", propOrder = {
    "currentStep",
    "mdErrorMessage",
    "mdStatus",
    "threeDOperationResult"
})
public class GetThreeDSessionResultResponse
    extends BaseOutput
{

    protected String currentStep;
    protected String mdErrorMessage;
    protected String mdStatus;
    protected ThreeDOperationResult threeDOperationResult;

    /**
     * Gets the value of the currentStep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * Sets the value of the currentStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentStep(String value) {
        this.currentStep = value;
    }

    /**
     * Gets the value of the mdErrorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdErrorMessage() {
        return mdErrorMessage;
    }

    /**
     * Sets the value of the mdErrorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdErrorMessage(String value) {
        this.mdErrorMessage = value;
    }

    /**
     * Gets the value of the mdStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdStatus() {
        return mdStatus;
    }

    /**
     * Sets the value of the mdStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdStatus(String value) {
        this.mdStatus = value;
    }

    /**
     * Gets the value of the threeDOperationResult property.
     * 
     * @return
     *     possible object is
     *     {@link ThreeDOperationResult }
     *     
     */
    public ThreeDOperationResult getThreeDOperationResult() {
        return threeDOperationResult;
    }

    /**
     * Sets the value of the threeDOperationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreeDOperationResult }
     *     
     */
    public void setThreeDOperationResult(ThreeDOperationResult value) {
        this.threeDOperationResult = value;
    }

}
