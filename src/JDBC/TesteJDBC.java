package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TesteJDBC {

	public static Connection openConnection() {

		Properties properties = new Properties();
		Connection connection = null;

		String path = System.getProperty("user.home");

		path += "\\Credenciais.txt";
		System.out.println(path);

		try (FileInputStream fin = new FileInputStream(path);) {

			properties.load(fin);

			try {
				Class.forName(properties.getProperty("JDBC_DRIVER"));

//              opening connection
				connection = (Connection) DriverManager.getConnection(properties.getProperty("DB_URL"),
						properties.getProperty("USER"), properties.getProperty("PASS"));

			} catch (ClassNotFoundException e) {
				System.out.println("This is from openConnection method");
				e.printStackTrace();
			} catch (SQLException f) {
				System.out.println("This is from openConnection method");
				f.printStackTrace();
			}
		} catch (IOException io) {
			System.out.println("This is from openConnection method");
			io.printStackTrace();
		}
		System.out.println("Deu certo!");
		return connection;
	}
}