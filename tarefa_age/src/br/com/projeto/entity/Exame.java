package br.com.projeto.entity;

import java.sql.Date;

public class Exame {
	
	private Long id;
	
	private String nome;
	
	private Paciente paciente;
	
	private Medico medico;
	
	private java.util.Date data;
	
	public Exame() {}
	
	public Exame(Long id, String nome, Paciente paciente, Medico medico, Date data) {
		this.id = id;
		this.nome = nome;
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * @return the data
	 */
	public java.util.Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(java.util.Date data) {
		this.data = data;
	}

//	public Date getData() {
//		return data;
//	}
//
//	public void setData(Date data) {
//		this.data = data;
//	}

}
