
package com.turkcelltech.mf.tpay.web.provision;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCardsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCardsResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://provision.web.tpay.mf.turkcelltech.com/}baseOutput">
 *       &lt;sequence>
 *         &lt;element name="cardList" type="{http://provision.web.tpay.mf.turkcelltech.com/}card" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="eulaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCardsResponse", propOrder = {
    "cardList",
    "eulaId"
})
public class GetCardsResponse
    extends BaseOutput
{

    @XmlElement(nillable = true)
    protected List<Card> cardList;
    protected String eulaId;

    /**
     * Gets the value of the cardList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Card }
     * 
     * 
     */
    public List<Card> getCardList() {
        if (cardList == null) {
            cardList = new ArrayList<Card>();
        }
        return this.cardList;
    }

    /**
     * Gets the value of the eulaId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEulaId() {
        return eulaId;
    }

    /**
     * Sets the value of the eulaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEulaId(String value) {
        this.eulaId = value;
    }

}
