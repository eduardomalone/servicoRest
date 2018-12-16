package br.com.projeto.servico;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.projeto.entity.Exame;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface SEIExame {
	
	@WebMethod
    Exame consultarSoap(int id);
	
	@WebMethod
	List<Exame> consultar();

}
