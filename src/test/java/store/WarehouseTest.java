package store;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseTest {
	Warehouse dao = new Warehouse();

	@BeforeEach
	void setUp() {
		dao.initDBConnection();
	}

	@Test
	void findProductTest() throws SQLException {
		int id = 1;
		ResultSet rs = dao.findProduct(id);
		
		while (rs.next()) {
		assertEquals(id, rs.getInt("id"));
		}
	}
	
	@Test
	void listProductTest() throws SQLException {
		ResultSet rs = dao.listProduct();
		
		while (rs.next()) {
		assertEquals(1, rs.getInt("id"));
		assertEquals("shirt", rs.getString("product"));
		assertEquals(10, rs.getInt("amount"));
		}
	}
	
	@Test
	void addProductTest() throws SQLException {
		int id = 2;
		String product = "pants";
		int amount = 20;
		assertTrue(dao.addProduct(id, product, amount));
	}
	
	@Test
	void addProductDuplicateTest() throws SQLException {
		int id = 1;
		String product = "shoes";
		int amount = 90;
		assertFalse(dao.addProduct(id, product, amount));
	}
	
	@Test
	void deleteProductTest() throws SQLException {
		int id = 2;
		assertFalse(dao.deleteProduct(id));
	}
	
	@Test
	void deleteProductAbsentTest() throws SQLException {
		int id = 10;
		assertTrue(dao.deleteProduct(id));
	}


}
