
package com.turkcelltech.mf.tpay.web.provision;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProvisionHistoryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProvisionHistoryResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="nextPartitionNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="transactionList" type="{http://provision.web.tpay.mf.turkcelltech.com/}transaction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProvisionHistoryResponse", propOrder = {
    "nextPartitionNo",
    "transactionList"
})
public class GetProvisionHistoryResponse
    extends BaseOutput
{

    protected Integer nextPartitionNo;
    @XmlElement(nillable = true)
    protected List<Transaction> transactionList;

    /**
     * Gets the value of the nextPartitionNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNextPartitionNo() {
        return nextPartitionNo;
    }

    /**
     * Sets the value of the nextPartitionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNextPartitionNo(Integer value) {
        this.nextPartitionNo = value;
    }

    /**
     * Gets the value of the transactionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transaction }
     * 
     * 
     */
    public List<Transaction> getTransactionList() {
        if (transactionList == null) {
            transactionList = new ArrayList<Transaction>();
        }
        return this.transactionList;
    }

}
