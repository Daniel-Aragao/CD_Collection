package cdc.Infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cdc.entitys.CD;

public class RepositorioCD {
	public boolean adicionar(CD cd){
		
		return true;
	}
	
	public boolean alterar(CD cd){
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"UPDATE pessoa SET nome = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidadeId = ?, estadoId =? WHERE id = ?");

//			stmt.setString(1, pessoa.getNome());
//			stmt.setString(2, pessoa.getRua());
//			stmt.setInt(3, pessoa.getNumero());
//			stmt.setString(4, pessoa.getComplemento());
//			stmt.setString(5, pessoa.getBairro());
//			stmt.setString(6, pessoa.getCep());
//			stmt.setInt(7, pessoa.getCidadeId());
//			stmt.setInt(8, pessoa.getEstadoId());
//			stmt.setInt(9, pessoa.getId());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
}
