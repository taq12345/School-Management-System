/**
 * 
 */
package dal;

import java.sql.*;

/**
 * @author Ehtisham
 *
 */
public class DBAccess {
	private static Connection con = null;
	private static Statement stmt = null;

	public static boolean createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root", "root");
			con.setAutoCommit(false);
			stmt = con.createStatement();
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (con == null)
			return false;
		else
			return true;
	}

	public static Statement getStatement() {
		return stmt;
	}

	public static Connection getConnection() {
		return con;
	}

	public static boolean closeConnection() {
		boolean check = true;
		try {
			con.close();
			con = null;
			stmt = null;
		} catch (SQLException e) {
			check = false;
		}
		return check;
	}
}
