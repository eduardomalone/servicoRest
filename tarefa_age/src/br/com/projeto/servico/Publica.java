package br.com.projeto.servico;

import javax.xml.ws.Endpoint;

public class Publica {

	public static void main(String[] args) {
        
        String porta = "8089";
        System.out.println("Publicando o serviço na porta: " + porta);
        Endpoint.publish("http://localhost:"+porta+"/exames", new SIBExame());
        System.out.println("Serviço publicado na porta: " + porta);        
    }
}
