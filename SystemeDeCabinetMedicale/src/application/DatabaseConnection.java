package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection connection;
	private static DatabaseConnection Instance;

	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cm", "root", "");
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
