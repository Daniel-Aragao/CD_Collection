package cdc.Infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cdc.entitys.Faixa;

public class RepositorioFaixa {
	public boolean adicionar(Faixa f){
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"insert into objeto (numero, descricao, peso, altura, largura, profundidade, valor, remetente_id, destinatario_id) values(?,?,?,?,?,?,?,?,?)");

//			stmt.setString(1, objeto.getNumero());
//			stmt.setString(2, objeto.getDescricao());
//			stmt.setDouble(3, objeto.getPeso());
//			stmt.setDouble(4, objeto.getAltura());
//			stmt.setDouble(5, objeto.getLargura());
//			stmt.setDouble(6, objeto.getProfundidade());
//			stmt.setDouble(7, objeto.getValor());
//			stmt.setInt(8, objeto.getRemetendeId());
//			stmt.setInt(9, objeto.getDestinatarioId());

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
