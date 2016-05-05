package cdc.Infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConexao() throws SQLException{
		
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" 
		+ "databaseName=CD_Collection;user=sa;password=ivia@2015;");
	}
}
