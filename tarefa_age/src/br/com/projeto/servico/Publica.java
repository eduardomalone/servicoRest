package br.com.projeto.servico;

import javax.xml.ws.Endpoint;

public class Publica {

	public static void main(String[] args) {
        
        String porta = "8089";
        System.out.println("Publicando o servi�o na porta: " + porta);
        Endpoint.publish("http://localhost:"+porta+"/exames", new SIBExame());
        System.out.println("Servi�o publicado na porta: " + porta);        
    }
}
