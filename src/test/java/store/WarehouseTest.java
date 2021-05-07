package store;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseTest {
	Warehouse dao = new Warehouse();

	@BeforeEach
	void setUp() {
		dao.initDBConnection();
	}

	@Test
	void FindProductTest() throws SQLException {
		int id = 1;
		ResultSet rs = dao.findProduct(id);
		
		while (rs.next()) {
		assertEquals(id, rs.getInt("id"));
		}
	}
	
	@Test
	void ListProductTest() throws SQLException {
		ResultSet rs = dao.listProduct();
		
		while (rs.next()) {
		assertEquals(1, rs.getInt("id"));
		assertEquals("shirt", rs.getString("product"));
		assertEquals(10, rs.getInt("amount"));
		}
	}

}
