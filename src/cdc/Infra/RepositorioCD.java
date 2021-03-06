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
			PreparedStatement Faixa_CompositorStmt = null;
			PreparedStatement Faixa_InterpreteStmt = null;
			
			String InsertCD =
				"INSERT INTO CD(cod_label, data_gravacao, data_compra, descricao, preco_compra) "
				+"VALUES "
				+"(?,?,?,?,?)";
	
		    String InsertFaixa =
	    		"INSERT INTO Faixa(codigo_CD, "
	    		+ "descricao, numero, tipo_composicao, tipo_gravacao)VALUES " 
	    		+"(?,?,?,?,?)";
		    
		    String InsertFaixa_Compositor = "INSERT INTO Faixa_por_compositor (codigo_faixa, codigo_compositor) "
		    		+ "VALUES (?, ?)" ;
		    String InsertFaixa_Interprete = "INSERT INTO Faixa_por_interprete (codigo_faixa, codigo_interprete) "
		    		+ "VALUES (?, ?)";
			    		
	
		    try {
		        con.setAutoCommit(false);
		        CDStmt = con.prepareStatement(InsertCD, Statement.RETURN_GENERATED_KEYS);
		        FaixaStmt = con.prepareStatement(InsertFaixa, Statement.RETURN_GENERATED_KEYS);
		        Faixa_CompositorStmt = con.prepareStatement(InsertFaixa_Compositor);
		        Faixa_InterpreteStmt = con.prepareStatement(InsertFaixa_Interprete);
		        
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
		        	FaixaStmt.setString(2, faixa.getDescricao());
		        	FaixaStmt.setInt(3, faixa.getNumero());
		        	FaixaStmt.setInt(4, faixa.getTipo_composicao());
		        	FaixaStmt.setString(5, faixa.getTipo_gravacao());
		        	
		        	FaixaStmt.executeUpdate();
		        	ResultSet resultFaixa = FaixaStmt.getGeneratedKeys();
		        	resultFaixa.next();
			        int codigoFaixa = resultFaixa.getInt(1);
		        	
		        	Faixa_CompositorStmt.setInt(1, codigoFaixa);
		        	Faixa_CompositorStmt.setInt(2, faixa.getCodigo_compositor());
		        	
		        	Faixa_InterpreteStmt.setInt(1, codigoFaixa);
		        	Faixa_InterpreteStmt.setInt(2, faixa.getCodigo_interprete());
		        	
		        	Faixa_CompositorStmt.executeUpdate();
		        	Faixa_InterpreteStmt.executeUpdate();
		        }
		        con.commit();
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		        if (con != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                con.rollback();
		            } catch(SQLException excep) {
		            	excep.printStackTrace();
		            }
		        }
		        return false;
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
			return false;
		}
	    return true;
	}
	
	
	public ArrayList<CD> get(String desc){
		ArrayList<CD> resultado = new ArrayList<CD>();
		
//		CD cd = new CD();
//		cd.setDescricao("teste teste teste teste teste teste teste teste teste");
//		cd.setData_compra(Calendar.getInstance());
//		cd.setData_gravacao(Calendar.getInstance());
//		cd.setPreco_compra(2.3);
//		resultado.add(cd);
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM CD WHERE descricao LIKE ? ORDER BY descricao");
			
			stmt.setString(1, "%"+desc+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Calendar dt_grav = Calendar.getInstance();
				Calendar dt_compr = Calendar.getInstance();
				
				dt_grav.setTime(rs.getDate("data_gravacao"));
				dt_compr.setTime(rs.getDate("data_compra"));
				
				CD cd = new CD(
						rs.getInt("codigo"), 
						rs.getInt("cod_label"),
						dt_grav,
						dt_compr,
						rs.getString("descricao"),
						rs.getDouble("preco_compra")); 
				
				resultado.add(cd);
			}
			
			
		}catch(SQLException ee){
			ee.printStackTrace();;
		}
		
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
