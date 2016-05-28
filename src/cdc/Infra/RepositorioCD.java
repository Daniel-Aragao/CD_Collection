package cdc.Infra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import cdc.entitys.CD;
import cdc.entitys.Faixa;

public class RepositorioCD {
	
	public boolean adicionar(CD cd){
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
				
			
			con = Conexao.getConexao();
			
			PreparedStatement CDStmt = null;
			PreparedStatement FaixaStmt = null;
	
			String InsertCD =
				"INSERT INTO CD(cod_label, data_gravacao, data_compra, descricao, preco_compra) "
				+"VALUES "
				+"(?,?,?,?,?)";
	
		    String InsertFaixa =
	    		"INSERT INTO Faixa(codigo_CD, codigo_compositor, "
	    		+ "descricao, numero, tipo_composicao, tipo_gravacao)VALUES " 
	    		+"(?,?,?,?,?,?)";
			    		
	
		    try {
		        con.setAutoCommit(false);
		        CDStmt = con.prepareStatement(InsertCD, Statement.RETURN_GENERATED_KEYS);
		        FaixaStmt = con.prepareStatement(InsertFaixa);
		        
		        CDStmt.setInt(1, cd.getCod_label());
		        CDStmt.setDate(2, new Date(cd.getData_gravacao().getTimeInMillis()));
		        CDStmt.setDate(3, new Date(cd.getData_compra().getTimeInMillis()));
		        CDStmt.setString(4, cd.getDescricao());
		        CDStmt.setDouble(5, cd.getPreco_compra());
		        
		        CDStmt.executeUpdate();
		        ResultSet result = CDStmt.getGeneratedKeys();
		        result.next();
		        int codigo = result.getInt(1);

		        for (Faixa faixa : cd.getFaixas()) {
		        	FaixaStmt.setInt(1, codigo);
		        	FaixaStmt.setInt(2, faixa.getCodigo_compositor());
		        	FaixaStmt.setString(3, faixa.getDescricao());
		        	FaixaStmt.setInt(4, faixa.getNumero());
		        	FaixaStmt.setInt(5, faixa.getTipo_composicao());
		        	FaixaStmt.setString(6, faixa.getTipo_gravacao());
		        	
		        	FaixaStmt.executeUpdate();
		        }
		        con.commit();
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		        if (con != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                con.rollback();
		                return false;
		            } catch(SQLException excep) {
		            	excep.printStackTrace();
		            }
		        }
		    } finally {
		        if (CDStmt != null) {
		        	CDStmt.close();
		        }
		        if (FaixaStmt != null) {
		        	FaixaStmt.close();
		        }
		        con.setAutoCommit(true);
		    }
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
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
