package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AcessoBanco {

	public static void main(String[] args) throws Exception{
		
		String sql = "SELECT CODIGO, NOME, SEXO, EMAIL FROM PESSOA";
		String url = "jdbc:mysql://127.0.0.1:3306/courseumdata";
		
		
		try(Connection con = DriverManager.getConnection(url, "root", "admin");
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery()){
			while(rs.next()) {
				String str = rs.getString("CODIGO") + " | "
						   + rs.getString("NOME")   + " | "
						   + rs.getString("SEXO")   + " | "
						   + rs.getString("EMAIL");
				System.out.println(str);
			}
		}
		
	}

}
