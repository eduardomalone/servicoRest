
package br.com.projeto.servico;

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
@WebServiceClient(name = "SIBExameService", targetNamespace = "http://servico.projeto.com.br/", wsdlLocation = "http://localhost:8089/exames?wsdl")
public class SIBExameService
    extends Service
{

    private final static URL SIBEXAMESERVICE_WSDL_LOCATION;
    private final static WebServiceException SIBEXAMESERVICE_EXCEPTION;
    private final static QName SIBEXAMESERVICE_QNAME = new QName("http://servico.projeto.com.br/", "SIBExameService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8089/exames?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SIBEXAMESERVICE_WSDL_LOCATION = url;
        SIBEXAMESERVICE_EXCEPTION = e;
    }

    public SIBExameService() {
        super(__getWsdlLocation(), SIBEXAMESERVICE_QNAME);
    }

    public SIBExameService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SIBEXAMESERVICE_QNAME, features);
    }

    public SIBExameService(URL wsdlLocation) {
        super(wsdlLocation, SIBEXAMESERVICE_QNAME);
    }

    public SIBExameService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SIBEXAMESERVICE_QNAME, features);
    }

    public SIBExameService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SIBExameService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SEIExame
     */
    @WebEndpoint(name = "SIBExamePort")
    public SEIExame getSIBExamePort() {
        return super.getPort(new QName("http://servico.projeto.com.br/", "SIBExamePort"), SEIExame.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SEIExame
     */
    @WebEndpoint(name = "SIBExamePort")
    public SEIExame getSIBExamePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servico.projeto.com.br/", "SIBExamePort"), SEIExame.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SIBEXAMESERVICE_EXCEPTION!= null) {
            throw SIBEXAMESERVICE_EXCEPTION;
        }
        return SIBEXAMESERVICE_WSDL_LOCATION;
    }

}
