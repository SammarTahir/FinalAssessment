package store;

import java.sql.SQLException;
import java.util.Scanner;

// hello demo
public class Store {

	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Warehouse dao = new Warehouse();
		int userInput = 0;
		dao.initDBConnection();
		System.out.println("Starting user interface.....");

		// While loop for user interface
		do {
			System.out.println("\nWelcome to store");
			System.out.println("1. List Products \n2. Find Product \n3. Add Product \n4. Remove Product \n9. Exit");
			System.out.print("\nEnter number: ");
			userInput = sc.nextInt();
			// Switch statement for user input
			switch (userInput) {
				// Shows a list of all products in database
				case 1:
					dao.listProduct();
					break;
				// Find product using a product ID
				case 2:
					System.out.print("Please enter product ID: ");
					dao.findProduct(sc.nextInt());
					break;
				// Adds new product to the database
				case 3:
					System.out.print("Please enter product ID: ");
					int id = sc.nextInt();
					System.out.print("Please enter product Name: ");
					String name = sc.next();
					System.out.print("Please enter product Amount: ");
					int amount = sc.nextInt();
					dao.addProduct(id, name, amount);
					break;
				// Removes product from the database
				case 4:
					System.out.print("Please enter product ID: ");
					dao.deleteProduct(sc.nextInt());
					break;
				case 9:
					System.out.println("Closing user interface......");
					break;
				default:
					System.out.println("Incorrect incorrect input\n");
					break;
			}
		} while (userInput != 9);
	}
}
