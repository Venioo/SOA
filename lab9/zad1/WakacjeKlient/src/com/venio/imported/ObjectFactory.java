
package com.venio.imported;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.venio.imported package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OdliczResponse_QNAME = new QName("http://venio.com/", "odliczResponse");
    private final static QName _Odlicz_QNAME = new QName("http://venio.com/", "odlicz");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.venio.imported
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Odlicz }
     * 
     */
    public Odlicz createOdlicz() {
        return new Odlicz();
    }

    /**
     * Create an instance of {@link OdliczResponse }
     * 
     */
    public OdliczResponse createOdliczResponse() {
        return new OdliczResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OdliczResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "odliczResponse")
    public JAXBElement<OdliczResponse> createOdliczResponse(OdliczResponse value) {
        return new JAXBElement<OdliczResponse>(_OdliczResponse_QNAME, OdliczResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Odlicz }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "odlicz")
    public JAXBElement<Odlicz> createOdlicz(Odlicz value) {
        return new JAXBElement<Odlicz>(_Odlicz_QNAME, Odlicz.class, null, value);
    }

}
