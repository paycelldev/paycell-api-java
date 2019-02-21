
package com.turkcelltech.mf.tpay.web.provision;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for target.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="target">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAYCELL"/>
 *     &lt;enumeration value="MERCHANT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "target")
@XmlEnum
public enum Target {

    PAYCELL,
    MERCHANT;

    public String value() {
        return name();
    }

    public static Target fromValue(String v) {
        return valueOf(v);
    }

}
