package Main;

import java.sql.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
	Connection conn = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/instituto","standart","1234standart");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(
 		"SELECT apellido FROM Usuarios");
		
	while (rs.next()) {
		String name = rs.getString("apellido");
		System.out.println(name);
	}
	rs.close();
	stmt.close();		
	conn.close();
    }
}