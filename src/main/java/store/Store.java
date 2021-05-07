package store;

import java.sql.SQLException;
import java.util.Scanner;

public class Store {

	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Warehouse dao = new Warehouse();
		int userInput = 0;
		dao.initDBConnection();
		System.out.println("Starting user interface.....");
		do {
		System.out.println("\nWelcome to store");
		System.out.println("1. List Products \n2. Find Product");
		System.out.print("\nEnter number: ");
		userInput = sc.nextInt();
		switch (userInput) {
			case 1:
				dao.listProduct();
				break;
			case 2:
				System.out.print("Please enter product ID: ");
				dao.findProduct(sc.nextInt());
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
