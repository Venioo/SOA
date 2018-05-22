
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

    private final static QName _SprzedajResponse_QNAME = new QName("http://venio.com/", "sprzedajResponse");
    private final static QName _Sprzedaj_QNAME = new QName("http://venio.com/", "sprzedaj");
    private final static QName _SprawdzKurs_QNAME = new QName("http://venio.com/", "sprawdzKurs");
    private final static QName _SprawdzKursResponse_QNAME = new QName("http://venio.com/", "sprawdzKursResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.venio.imported
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SprawdzKursResponse }
     * 
     */
    public SprawdzKursResponse createSprawdzKursResponse() {
        return new SprawdzKursResponse();
    }

    /**
     * Create an instance of {@link SprawdzKurs }
     * 
     */
    public SprawdzKurs createSprawdzKurs() {
        return new SprawdzKurs();
    }

    /**
     * Create an instance of {@link Sprzedaj }
     * 
     */
    public Sprzedaj createSprzedaj() {
        return new Sprzedaj();
    }

    /**
     * Create an instance of {@link SprzedajResponse }
     * 
     */
    public SprzedajResponse createSprzedajResponse() {
        return new SprzedajResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SprzedajResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "sprzedajResponse")
    public JAXBElement<SprzedajResponse> createSprzedajResponse(SprzedajResponse value) {
        return new JAXBElement<SprzedajResponse>(_SprzedajResponse_QNAME, SprzedajResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sprzedaj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "sprzedaj")
    public JAXBElement<Sprzedaj> createSprzedaj(Sprzedaj value) {
        return new JAXBElement<Sprzedaj>(_Sprzedaj_QNAME, Sprzedaj.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SprawdzKurs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "sprawdzKurs")
    public JAXBElement<SprawdzKurs> createSprawdzKurs(SprawdzKurs value) {
        return new JAXBElement<SprawdzKurs>(_SprawdzKurs_QNAME, SprawdzKurs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SprawdzKursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://venio.com/", name = "sprawdzKursResponse")
    public JAXBElement<SprawdzKursResponse> createSprawdzKursResponse(SprawdzKursResponse value) {
        return new JAXBElement<SprawdzKursResponse>(_SprawdzKursResponse_QNAME, SprawdzKursResponse.class, null, value);
    }

}
