package cdc.Infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import cdc.entitys.CD;

public class RepositorioCD {
	public boolean adicionar(CD cd){
		
		return true;
	}
	
	public ArrayList<CD> get(String desc){
		ArrayList<CD> resultado = new ArrayList<CD>();
		
		CD cd = new CD();
		cd.setDescricao("teste teste teste teste teste teste teste teste teste");
		cd.setData_compra(Calendar.getInstance());
		cd.setData_gravacao(Calendar.getInstance());
		cd.setPreco_compra(2.3);
		resultado.add(cd);
		
//		Connection con = null;		
//		PreparedStatement stmt = null;
//		
//		try{
//			con = Conexao.getConexao();
//			stmt = con.prepareStatement("SELECT * FROM CD WHERE descricao LIKE ? ORDERBY descricao");
//			
//			stmt.setString(1, "%"+desc+"%");
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()){
//				CD cd = new CD(
//						rs.getInt("codigo"), 
//						rs.getInt("cod_label"),
//						rs.getTimestamp("data_gravacao"),
//						rs.getTimestamp("data_compra"),
//						rs.getString("descricao"),
//						rs.getDouble("preco_compra")); 
//				
//				resultado.add(cd);
//			}
//			
//			
//		}catch(SQLException ee){
//			ee.printStackTrace();;
//		}
		
		return resultado;
	}
	
	public boolean alterar(CD cd){
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"UPDATE CD "
					+ "SET cod_label = ?, data_compra = ?, "
					+ "data_gravacao = ?, descricao = ?, preco_compra = ? "
					+ "WHERE codigo = ?");

			stmt.setLong(1, cd.getCod_label());
			stmt.setDate(2, new java.sql.Date(cd.getData_compra().getTimeInMillis()));
			stmt.setDate(3, new java.sql.Date(cd.getData_gravacao().getTimeInMillis()));
			stmt.setString(4, cd.getDescricao());
			stmt.setDouble(5, cd.getPreco_compra());
			stmt.setDouble(6, cd.getCodigo());

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
