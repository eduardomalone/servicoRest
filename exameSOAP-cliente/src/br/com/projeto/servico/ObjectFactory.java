
package br.com.projeto.servico;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.projeto.servico package. 
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

    private final static QName _ConsultarResponse_QNAME = new QName("http://servico.projeto.com.br/", "consultarResponse");
    private final static QName _Consultar_QNAME = new QName("http://servico.projeto.com.br/", "consultar");
    private final static QName _ConsultarSoapResponse_QNAME = new QName("http://servico.projeto.com.br/", "consultarSoapResponse");
    private final static QName _ConsultarSoap_QNAME = new QName("http://servico.projeto.com.br/", "consultarSoap");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.projeto.servico
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarResponse }
     * 
     */
    public ConsultarResponse createConsultarResponse() {
        return new ConsultarResponse();
    }

    /**
     * Create an instance of {@link ConsultarSoap }
     * 
     */
    public ConsultarSoap createConsultarSoap() {
        return new ConsultarSoap();
    }

    /**
     * Create an instance of {@link Consultar }
     * 
     */
    public Consultar createConsultar() {
        return new Consultar();
    }

    /**
     * Create an instance of {@link ConsultarSoapResponse }
     * 
     */
    public ConsultarSoapResponse createConsultarSoapResponse() {
        return new ConsultarSoapResponse();
    }

    /**
     * Create an instance of {@link Exame }
     * 
     */
    public Exame createExame() {
        return new Exame();
    }

    /**
     * Create an instance of {@link Paciente }
     * 
     */
    public Paciente createPaciente() {
        return new Paciente();
    }

    /**
     * Create an instance of {@link Medico }
     * 
     */
    public Medico createMedico() {
        return new Medico();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.projeto.com.br/", name = "consultarResponse")
    public JAXBElement<ConsultarResponse> createConsultarResponse(ConsultarResponse value) {
        return new JAXBElement<ConsultarResponse>(_ConsultarResponse_QNAME, ConsultarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Consultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.projeto.com.br/", name = "consultar")
    public JAXBElement<Consultar> createConsultar(Consultar value) {
        return new JAXBElement<Consultar>(_Consultar_QNAME, Consultar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSoapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.projeto.com.br/", name = "consultarSoapResponse")
    public JAXBElement<ConsultarSoapResponse> createConsultarSoapResponse(ConsultarSoapResponse value) {
        return new JAXBElement<ConsultarSoapResponse>(_ConsultarSoapResponse_QNAME, ConsultarSoapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico.projeto.com.br/", name = "consultarSoap")
    public JAXBElement<ConsultarSoap> createConsultarSoap(ConsultarSoap value) {
        return new JAXBElement<ConsultarSoap>(_ConsultarSoap_QNAME, ConsultarSoap.class, null, value);
    }

}
