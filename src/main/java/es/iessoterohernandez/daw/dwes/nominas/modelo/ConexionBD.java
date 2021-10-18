/**
 * 
 */
package es.iessoterohernandez.daw.dwes.nominas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fjdl
 * DriverManager para la conexión a la base de datos
 */

public class ConexionBD {

	private static Connection con = null;
	private static final String conUrl = "jdbc:mysql://localhost:3306/laboral?user=root&password=Luiruirom_99"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//	private static final String conUrl = "jdbc:mysql://localhost:3306/classicmodels?user=root&password=root";

	public static Connection getConnection() {
		try {
			if (con == null) {
				con = DriverManager.getConnection(ConexionBD.conUrl);
				System.out.println("Conexión realizada correctamente");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
