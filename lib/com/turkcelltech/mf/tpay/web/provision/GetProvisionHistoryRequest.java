
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProvisionHistoryRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProvisionHistoryRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseInput">
 *       &lt;sequence>
 *         &lt;element name="merchantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partitionNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reconciliationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProvisionHistoryRequest", propOrder = {
    "merchantCode",
    "partitionNo",
    "reconciliationDate"
})
public class GetProvisionHistoryRequest
    extends BaseInput
{

    protected String merchantCode;
    protected Integer partitionNo;
    protected String reconciliationDate;

    /**
     * Gets the value of the merchantCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * Sets the value of the merchantCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCode(String value) {
        this.merchantCode = value;
    }

    /**
     * Gets the value of the partitionNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPartitionNo() {
        return partitionNo;
    }

    /**
     * Sets the value of the partitionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPartitionNo(Integer value) {
        this.partitionNo = value;
    }

    /**
     * Gets the value of the reconciliationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReconciliationDate() {
        return reconciliationDate;
    }

    /**
     * Sets the value of the reconciliationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReconciliationDate(String value) {
        this.reconciliationDate = value;
    }

}
