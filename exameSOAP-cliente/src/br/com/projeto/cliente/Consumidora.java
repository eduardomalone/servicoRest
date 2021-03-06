package br.com.projeto.cliente;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import br.com.projeto.servico.Exame;
import br.com.projeto.servico.SEIExame;
import br.com.projeto.utils.Conexao;

public class Consumidora {
	
	private static Scanner in = new Scanner(System.in);
    private static SEIExame seiExame = Conexao.getConnection();

    public static void main(String[] args) {
    	 
        int opcao = 0;
 
        do {
            System.out.println("<1> - criar\n" + 
                               "<2> - alterar\n" + 
                               "<3> - remover\n" + 
                               "<4> - buscar um exame\n" + 
                               "<5> - buscar todas os Exames\n" + 
                               "<0> - sair\n");
            System.out.println("Escolha a op��o: ");
            opcao = in.nextInt();
            
            switch (opcao) {
            case 1: 
                //criar();
                break;
            case 2: 
                //alterar();
                break;                
            case 3: 
                //remover();
                break;
            case 4: 
                ler();
                break;
            case 5: 
                listar();
                break;
 
            default:
                break;
            }
 
        } while (opcao != 0);
    }
 
     
    private static void ler() {
        System.out.println("Digite o id do exame: ");
        int id = in.nextInt();
         
        Exame exame = seiExame.consultarSoap(id);
         
        if(exame != null){
            System.out.println("Enviado ao servi�o com sucesso");
            System.out.println("id -> " + exame.getId());
            System.out.println("t�tulo -> " + exame.getNome());
            System.out.println("paciente -> " + exame.getPaciente());
            System.out.println("m�dico -> " + exame.getMedico());
            System.out.println("data -> " + exame.getData());
        } else {
            System.out.println("Opera��o n�o executada");
        }
    }
     
    private static void listar() {
        List<Exame> exame2 = seiExame.consultar();
         
        if(exame2 != null){
             
            for(Exame exames: exame2){            
                System.out.println("Enviado ao servi�o com sucesso");
                System.out.println("id -> " + exames.getId());
                System.out.println("t�tulo -> " + exames.getNome());
                System.out.println("paciente -> " + exames.getPaciente());
                System.out.println("m�dico -> " + exames.getMedico());
                System.out.println("data -> " + exames.getData() +"\n");
            }
        } else {
            System.out.println("Problemas ao enviar ao servi�o");
        }
    }
     
    private static XMLGregorianCalendar gerarData(){
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
         
        try {
            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }        
        return null;
    }
}

