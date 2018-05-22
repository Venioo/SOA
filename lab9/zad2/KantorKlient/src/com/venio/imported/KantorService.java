
package com.venio.imported;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "KantorService", targetNamespace = "http://venio.com/", wsdlLocation = "http://localhost:8080/KantorWebService_war_exploded/Kantor?wsdl")
public class KantorService
    extends Service
{

    private final static URL KANTORSERVICE_WSDL_LOCATION;
    private final static WebServiceException KANTORSERVICE_EXCEPTION;
    private final static QName KANTORSERVICE_QNAME = new QName("http://venio.com/", "KantorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/KantorWebService_war_exploded/Kantor?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        KANTORSERVICE_WSDL_LOCATION = url;
        KANTORSERVICE_EXCEPTION = e;
    }

    public KantorService() {
        super(__getWsdlLocation(), KANTORSERVICE_QNAME);
    }

    public KantorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), KANTORSERVICE_QNAME, features);
    }

    public KantorService(URL wsdlLocation) {
        super(wsdlLocation, KANTORSERVICE_QNAME);
    }

    public KantorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, KANTORSERVICE_QNAME, features);
    }

    public KantorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public KantorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Kantor
     */
    @WebEndpoint(name = "KantorPort")
    public Kantor getKantorPort() {
        return super.getPort(new QName("http://venio.com/", "KantorPort"), Kantor.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Kantor
     */
    @WebEndpoint(name = "KantorPort")
    public Kantor getKantorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://venio.com/", "KantorPort"), Kantor.class, features);
    }

    private static URL __getWsdlLocation() {
        if (KANTORSERVICE_EXCEPTION!= null) {
            throw KANTORSERVICE_EXCEPTION;
        }
        return KANTORSERVICE_WSDL_LOCATION;
    }

}
