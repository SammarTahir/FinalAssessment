package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Warehouse {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	public ResultSet initDBConnection() {
		ResultSet rs = null;
		String cmd = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/finalassessment?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT";
			con = DriverManager.getConnection(url, "root", "admin");
			stmt = con.createStatement();
			
			//Getting result set from database 
			cmd = "select * from finalassessment.store;";
			rs = stmt.executeQuery(cmd);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Failed to initialise DB Connection");
		}
		return rs;
	}
	public void addProduct() {
		
	}
	
	public ResultSet listProduct() throws SQLException {
		ResultSet rs = null;
		String cmd = null;
		cmd = "select * from finalassessment.store;";
		rs = stmt.executeQuery(cmd);

		while (rs.next()) {
			int id = rs.getInt("id");
			String p = rs.getString("product");
			int a = rs.getInt("amount");
			System.out.println("ID: " + id + "	Product: "+ p + "   Amount: " + a);
		}
		return rs;
	}

	public ResultSet findProduct(int id) throws SQLException {
		ResultSet rs = null;
		String cmd = null;
		cmd = "select * from finalassessment.store where id = " + id + ";";
		rs = stmt.executeQuery(cmd);

		while (rs.next()) {
			String p = rs.getString("product");
			int a = rs.getInt("amount");
			System.out.println("Product: "+ p + "   Amount: " + a);
		}
		return rs;
	}
	
	public void deleteProduct(int id) throws SQLException {
		String cmd = null;
		ResultSet rs = null;
		boolean repeatId = true;
		cmd = "select * from finalassessment.store;";
		rs = stmt.executeQuery(cmd);
		while (rs.next()) {
			int found = rs.getInt("id");
			if (found == id) {
				repeatId = false;
				cmd = "Delete from finalassessment.store where id = " + id + ";";
				stmt.executeUpdate(cmd);
				System.out.println("Product with ID: " + id + " is removed from the database");
			}
		}

		if (repeatId) {
			System.out.println("Could not find product with ID: " + id);
		}
	

	}
	
	public void addProduct(int id, String name, int amount) throws SQLException {
		String cmd = null;
		ResultSet rs = null;
		boolean repeatId = true;
		cmd = "select * from finalassessment.store;";
		rs = stmt.executeQuery(cmd);

		while (rs.next()) {
			int found = rs.getInt("id");
			if (found == id) {
				repeatId = false;
				System.out.println("There is already a product with ID: " + id);
			}
		}
		if (repeatId) {
			cmd = "Insert into finalassessment.store values (" + id + ", '"+ name +"', " + amount + ");";
			stmt.executeUpdate(cmd);

		}

	}
}
