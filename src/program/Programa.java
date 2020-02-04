package program;

// Atualiza registro JDBC 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args)  {

		
		Connection conn = null;
		PreparedStatement st = null;
		
		
		try {
			
			
			conn = DB.getConnection();
			st = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary+ ? "
					+ "WHERE "
					+ " (DepartmentId= ?)");
			
			st.setDouble(1,200.0); // Substitui o ? 
			st.setInt(2, 2);
			
			int linhasAfetadas = st.executeUpdate();
			
			System.out.println("Feito ! Linhas afetadas = " + linhasAfetadas);
			
			
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		finally {
			
			DB.closeStatemant(st);
			try {
				DB.closeConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
			}
}
	
	
