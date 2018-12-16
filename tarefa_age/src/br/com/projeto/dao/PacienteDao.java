package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.entity.Paciente;
import br.com.projeto.util.ConnectionFactory;

public class PacienteDao {
	
	/**
	 * Busca paciente por ID.
	 */
	public Paciente findById(Long id) throws Exception {
		
		Paciente paciente = null;
		
		String query = "SELECT * FROM dbo.Paciente WHERE id = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				paciente = new Paciente(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getString("endereco"),
						rs.getString("cpf"));
				
			}
			
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return paciente;
	}
	
	/**
	 * Busca todos os paciente ativos.
	 */
	public List<Paciente> findAll() throws Exception {
		
		List<Paciente> pacientes = new ArrayList<>();
		
		String query = "SELECT * FROM dbo.Paciente WHERE ativo = 1";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				pacientes.add(new Paciente(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getString("endereco"),
						rs.getString("cpf")));
				
			}
			
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return pacientes;
		
	}

	/**
	 * Cadastra paciente.
	 */
	public void create(Paciente paciente) throws Exception {
		
		String query = "INSERT INTO dbo.Paciente(nome, cpf, endereco, ativo) VALUES (?,?,?, 1)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getEndereco());
			
			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
	/**
	 * Atualiza paciente.
	 */
	public void update(Paciente paciente) throws Exception {
		
		String query = "UPDATE dbo.Paciente SET "
				+ "nome = ?, cpf = ?, endereco = ? "
				+ "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getEndereco());
			stmt.setLong(4, paciente.getId());
			
			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
	/**
	 * Exclus�o l�gica de um paciente.
	 */
	public void exclusaoLogica(Long id) throws Exception {
		
		String query = "UPDATE dbo.Paciente SET "
				+ "ativo = 0 "
				+ "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setLong(1, id);
			
			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
}
