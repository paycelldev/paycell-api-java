
package com.turkcelltech.mf.tpay.web.provision;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for summaryReconciliationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="summaryReconciliationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="extraParameters" type="{http://provision.web.tpay.mf.turkcelltech.com/}extraParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="merchantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reconciliationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestHeader" type="{http://provision.web.tpay.mf.turkcelltech.com/}requestHeader" minOccurs="0"/>
 *         &lt;element name="totalPostAuthAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalPostAuthCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalPostAuthReverseAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalPostAuthReverseCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalPreAuthAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalPreAuthCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalPreAuthReverseAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalPreAuthReverseCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalRefundAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalRefundCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalReverseAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalReverseCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalSaleAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalSaleCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summaryReconciliationRequest", propOrder = {
    "extraParameters",
    "merchantCode",
    "reconciliationDate",
    "requestHeader",
    "totalPostAuthAmount",
    "totalPostAuthCount",
    "totalPostAuthReverseAmount",
    "totalPostAuthReverseCount",
    "totalPreAuthAmount",
    "totalPreAuthCount",
    "totalPreAuthReverseAmount",
    "totalPreAuthReverseCount",
    "totalRefundAmount",
    "totalRefundCount",
    "totalReverseAmount",
    "totalReverseCount",
    "totalSaleAmount",
    "totalSaleCount"
})
public class SummaryReconciliationRequest {

    @XmlElement(nillable = true)
    protected List<ExtraParameter> extraParameters;
    protected String merchantCode;
    protected String reconciliationDate;
    protected RequestHeader requestHeader;
    protected String totalPostAuthAmount;
    protected Integer totalPostAuthCount;
    protected String totalPostAuthReverseAmount;
    protected Integer totalPostAuthReverseCount;
    protected String totalPreAuthAmount;
    protected Integer totalPreAuthCount;
    protected String totalPreAuthReverseAmount;
    protected Integer totalPreAuthReverseCount;
    protected String totalRefundAmount;
    protected Integer totalRefundCount;
    protected String totalReverseAmount;
    protected Integer totalReverseCount;
    protected String totalSaleAmount;
    protected Integer totalSaleCount;

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

    /**
     * Gets the value of the totalPostAuthAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPostAuthAmount() {
        return totalPostAuthAmount;
    }

    /**
     * Sets the value of the totalPostAuthAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPostAuthAmount(String value) {
        this.totalPostAuthAmount = value;
    }

    /**
     * Gets the value of the totalPostAuthCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalPostAuthCount() {
        return totalPostAuthCount;
    }

    /**
     * Sets the value of the totalPostAuthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalPostAuthCount(Integer value) {
        this.totalPostAuthCount = value;
    }

    /**
     * Gets the value of the totalPostAuthReverseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPostAuthReverseAmount() {
        return totalPostAuthReverseAmount;
    }

    /**
     * Sets the value of the totalPostAuthReverseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPostAuthReverseAmount(String value) {
        this.totalPostAuthReverseAmount = value;
    }

    /**
     * Gets the value of the totalPostAuthReverseCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalPostAuthReverseCount() {
        return totalPostAuthReverseCount;
    }

    /**
     * Sets the value of the totalPostAuthReverseCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalPostAuthReverseCount(Integer value) {
        this.totalPostAuthReverseCount = value;
    }

    /**
     * Gets the value of the totalPreAuthAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPreAuthAmount() {
        return totalPreAuthAmount;
    }

    /**
     * Sets the value of the totalPreAuthAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPreAuthAmount(String value) {
        this.totalPreAuthAmount = value;
    }

    /**
     * Gets the value of the totalPreAuthCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalPreAuthCount() {
        return totalPreAuthCount;
    }

    /**
     * Sets the value of the totalPreAuthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalPreAuthCount(Integer value) {
        this.totalPreAuthCount = value;
    }

    /**
     * Gets the value of the totalPreAuthReverseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPreAuthReverseAmount() {
        return totalPreAuthReverseAmount;
    }

    /**
     * Sets the value of the totalPreAuthReverseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPreAuthReverseAmount(String value) {
        this.totalPreAuthReverseAmount = value;
    }

    /**
     * Gets the value of the totalPreAuthReverseCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalPreAuthReverseCount() {
        return totalPreAuthReverseCount;
    }

    /**
     * Sets the value of the totalPreAuthReverseCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalPreAuthReverseCount(Integer value) {
        this.totalPreAuthReverseCount = value;
    }

    /**
     * Gets the value of the totalRefundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalRefundAmount() {
        return totalRefundAmount;
    }

    /**
     * Sets the value of the totalRefundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalRefundAmount(String value) {
        this.totalRefundAmount = value;
    }

    /**
     * Gets the value of the totalRefundCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalRefundCount() {
        return totalRefundCount;
    }

    /**
     * Sets the value of the totalRefundCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalRefundCount(Integer value) {
        this.totalRefundCount = value;
    }

    /**
     * Gets the value of the totalReverseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalReverseAmount() {
        return totalReverseAmount;
    }

    /**
     * Sets the value of the totalReverseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalReverseAmount(String value) {
        this.totalReverseAmount = value;
    }

    /**
     * Gets the value of the totalReverseCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalReverseCount() {
        return totalReverseCount;
    }

    /**
     * Sets the value of the totalReverseCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalReverseCount(Integer value) {
        this.totalReverseCount = value;
    }

    /**
     * Gets the value of the totalSaleAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalSaleAmount() {
        return totalSaleAmount;
    }

    /**
     * Sets the value of the totalSaleAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalSaleAmount(String value) {
        this.totalSaleAmount = value;
    }

    /**
     * Gets the value of the totalSaleCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalSaleCount() {
        return totalSaleCount;
    }

    /**
     * Sets the value of the totalSaleCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalSaleCount(Integer value) {
        this.totalSaleCount = value;
    }

}
