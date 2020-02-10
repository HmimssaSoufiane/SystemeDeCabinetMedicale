package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection connection;
	private static DatabaseConnection Instance;
	private BufferedReader bufferedReader;

	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			bufferedReader = new BufferedReader(new FileReader("BDconfig.txt"));
			String string=bufferedReader.readLine();
			String[] array=string.split(",");
			connection = DriverManager.getConnection(array[0], array[1], array[2]);
			System.out.println("Base de données correctement connectée !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnection getInstance() {
		if (Instance == null)
			return new DatabaseConnection();
		return Instance;
	}

}
