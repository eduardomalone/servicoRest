package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.entity.Medico;
import br.com.projeto.util.ConnectionFactory;

public class MedicoDao {
	
	/**
	 * Busca m�dico por ID.
	 */
	public Medico findById(Long id) throws Exception {
		
		String query = "SELECT * FROM dbo.Medico WHERE id = ?";
		
		Medico medico = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				medico = new Medico(
						rs.getLong("id"), 
						rs.getString("nome"), 
						rs.getString("cpf"), 
						rs.getString("crm"));
				
			}
			
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return medico;
		
	}

	/**
	 * Busca todos os m�dicos ativos.
	 */
	public List<Medico> findAll() throws Exception {
		
		String query = "SELECT * FROM dbo.Medico WHERE ativo = 1";
		
		List<Medico> medicos = new ArrayList<Medico>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				medicos.add(new Medico(
						rs.getLong("id"), 
						rs.getString("nome"), 
						rs.getString("cpf"), 
						rs.getString("crm")));
				
			}
			
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return medicos;
		
	}
	
	/**
	 * Cadastra m�dico.
	 */
	public void create(Medico medico) throws Exception {
		
		String query = "INSERT INTO dbo.Medico(nome, cpf, crm, ativo) VALUES (?,?,?, 1)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
		
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, medico.getNome());
			stmt.setString(2, medico.getCpf());
			stmt.setString(3, medico.getCrm());
			
			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
	/**
	 * Atualiza m�dico.
	 */
	public void update(Medico medico) throws Exception {
		
		String query = "UPDATE dbo.Medico SET "
				+ "nome = ?, cpf = ?, crm = ? "
				+ "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, medico.getNome());
			stmt.setString(2, medico.getCpf());
			stmt.setString(3, medico.getCrm());
			stmt.setLong(4, medico.getId());

			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
	/**
	 * Exclus�o l�gica de um m�dico.
	 */
	public void exclusaoLogica(Long id) throws Exception {
		
		String query = "UPDATE dbo.Medico SET "
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
