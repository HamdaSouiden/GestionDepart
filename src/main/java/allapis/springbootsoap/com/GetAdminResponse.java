//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.06 at 09:54:52 PM CEST 
//


package allapis.springbootsoap.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adminInfo" type="{http://com.springbootsoap.allapis}adminInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "adminInfo"
})
@XmlRootElement(name = "getAdminResponse")
public class GetAdminResponse {

    @XmlElement(required = true)
    protected AdminInfo adminInfo;

    /**
     * Gets the value of the adminInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AdminInfo }
     *     
     */
    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    /**
     * Sets the value of the adminInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminInfo }
     *     
     */
    public void setAdminInfo(AdminInfo value) {
        this.adminInfo = value;
    }

}
