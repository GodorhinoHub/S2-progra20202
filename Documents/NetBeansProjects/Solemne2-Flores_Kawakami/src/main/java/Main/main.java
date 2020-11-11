package Main;

import java.sql.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
	Connection conn = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/colegio","standart","1234standart");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(
 		"SELECT login FROM Administrador");
		
	while (rs.next()) {
		String name = rs.getString("login");
		System.out.println(name);
	}
	rs.close();
	stmt.close();		
	conn.close();
    }
}