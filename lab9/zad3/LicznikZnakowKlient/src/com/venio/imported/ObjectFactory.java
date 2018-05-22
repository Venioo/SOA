
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

    private final static QName _PoliczResponse_QNAME = new QName("http://venio.com/", "policzResponse");
    private final static QName _Policz_QNAME = new QName("http://venio.com/", "policz");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.venio.imported
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PoliczResponse }
     * 
     */
    public PoliczResponse createPoliczResponse() {
        return new PoliczResponse();
    }

    /**
     * Create an instance of {@link Policz }
     * 
     */
    public Policz createPolicz() {
        return new Policz();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PoliczResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "policzResponse")
    public JAXBElement<PoliczResponse> createPoliczResponse(PoliczResponse value) {
        return new JAXBElement<PoliczResponse>(_PoliczResponse_QNAME, PoliczResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Policz }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "policz")
    public JAXBElement<Policz> createPolicz(Policz value) {
        return new JAXBElement<Policz>(_Policz_QNAME, Policz.class, null, value);
    }

}
