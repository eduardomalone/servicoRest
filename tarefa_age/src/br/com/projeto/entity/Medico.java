package br.com.projeto.entity;

public class Medico {
	
	private Long id;
	private String nome;
	private String crm;
	private String cpf;
	
	//método construtor
	public Medico() {}
	
	public Medico(Long id, String nome, String cpf, String crm) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.crm = crm;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the crm
	 */
	public String getCrm() {
		return crm;
	}

	/**
	 * @param crm the crm to set
	 */
	public void setCrm(String crm) {
		this.crm = crm;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
