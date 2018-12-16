package br.com.projeto.utils;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.projeto.servico.SEIExame;


public class Conexao {

	 private static final SEIExame sei = construirConexao(); 
	 
	    private static SEIExame construirConexao() {
	        try {            
	            URL url = new URL("http://localhost:8089/exames?wsdl");
	              
	            QName qname = new QName("http://servico.projeto.com.br/", "SIBExameService");
	      
	            Service service = Service.create(url, qname);
	             
	            return service.getPort(SEIExame.class);
	 
	        } catch (Exception ex) {
	            System.err.println("Problemas ao conectar no serviço: " + ex.getMessage());
	            ex.printStackTrace();
	        }
	        return null;
	    }
	 
	    public static SEIExame getConnection() {
	        return sei;
	    }
	
}
