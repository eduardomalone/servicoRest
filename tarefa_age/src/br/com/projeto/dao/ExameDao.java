package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.entity.Exame;
import br.com.projeto.entity.Medico;
import br.com.projeto.entity.Paciente;
import br.com.projeto.util.ConnectionFactory;

public class ExameDao {
	
	/**
	 * Busca todos os exames ativos.
	 * OBS.: O médico e paciente vinculados devem estar ativos também.
	 */
	public List<Exame> findAll() throws Exception {
		
		List<Exame> exames = new ArrayList<Exame>();
		
		String query = "SELECT E.* "
				+ "FROM dbo.Exame E "
				+ "INNER JOIN dbo.Paciente P ON E.idPaciente = P.id "
				+ "INNER JOIN dbo.Medico M ON E.idMedico = M.id "
				+ "WHERE E.ativo = 1 "
				+ "AND P.ativo = 1 "
				+ "AND M.ativo = 1 ";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				exames.add(new Exame(
						rs.getLong("id"), 
						rs.getString("nome"), 
						new PacienteDao().findById(rs.getLong("idPaciente")), 
						new MedicoDao().findById(rs.getLong("idMedico")), 
						rs.getDate("data")));
				
			}
			
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return exames;
		
	}
	
	/**
	 * Busca Exame por ID.
	 */
	public Exame findById(int id) throws Exception {
		
		String query = "SELECT * FROM dbo.Exame WHERE id = ?";
		
		Exame exame = null;
		Paciente paciente = null;
		Medico medico = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				Exame exameRetorno = new Exame();
				exameRetorno.setId(rs.getLong("id"));
				exameRetorno.setNome(rs.getString("nome"));
			}
			
			
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
		return exame;
		
	}

	
	/**
	 * Cadastra exame.
	 */
	public void create(Exame exame) throws Exception {
		
		String query = "INSERT INTO dbo.Exame(nome, idPaciente, idMedico, data, ativo) VALUES (?,?,?,?, 1)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, exame.getNome());
			stmt.setLong(2, exame.getPaciente().getId());
			stmt.setLong(3, exame.getMedico().getId());
			stmt.setDate(4, new Date(exame.getData().getTime()));
			
			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
	/**
	 * Atualiza exame.
	 */
	public void update(Exame exame) throws Exception {
		
		String query = "UPDATE dbo.Exame SET "
				+ "nome = ?, idMedico = ?, idPaciente = ?, data = ? "
				+ "WHERE id = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, exame.getNome());
			stmt.setLong(2, exame.getMedico().getId());
			stmt.setLong(3, exame.getPaciente().getId());
			stmt.setDate(4, new Date(exame.getData().getTime()));
			
			stmt.setLong(5, exame.getId());

			stmt.execute();
			
		} finally {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		
	}
	
	/**
	 * Exclusão lógica de um exame.
	 */
	public void exclusaoLogica(Long id) throws Exception {
		
		String query = "UPDATE dbo.Exame SET "
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
