package br.com.projeto.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import br.com.projeto.dao.PacienteDao;
import br.com.projeto.entity.Paciente;

public class PacienteAction implements Action {
	
	private Paciente paciente;
	
	private List<Paciente> pacientes;

	@Override
	public String execute() throws Exception {
		
		this.pacientes = new PacienteDao().findAll();
		
		return "success";
	}
	
	/**
	 * Método que redireciona para a tela de formulário.
	 */
	public String telaForm() {
		return "form";
	}
	
	/**
	 * Método que cadastra ou edita um paciente.
	 */
	public String salvar() {
		
		try {
			
			if(paciente.getId() != null) {
				
				// Atualizar
				if(!paciente.getCpf().equals("") && !paciente.getNome().equals("")
						&& !paciente.getEndereco().equals("")) {
					new PacienteDao().update(paciente);
				}
				
				
			} else {
				
				// Criar
				if(!paciente.getCpf().equals("") && !paciente.getNome().equals("")
						&& !paciente.getEndereco().equals("")) {
					new PacienteDao().create(paciente);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirectSuccess";
	}
	
	/**
	 * Método que realiza a exclusão lógica de um paciente.
	 */
	public String remover() {
		
		try {
			
			new PacienteDao().exclusaoLogica(paciente.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirectSuccess";
		
	}
	
	// Getters and Setters

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
