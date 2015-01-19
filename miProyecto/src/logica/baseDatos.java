package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class baseDatos {
	//creamos las variables
	private static Connection connection;
	private static Statement statement;
	
	public static void conexion() {
		System.out.println("Empieza la conexion a la BD");
		try {
			//inicializamos
			connection = DriverManager.getConnection("jdbc:sqlite:circuitos.db");
			statement = connection.createStatement();
			try {
				//creamos la tabla
				statement.executeUpdate("create table registro (nombre String, puntuacion int)");
			} catch (SQLException e) {
				if (!e.getMessage().equals("table registro already exists"))  // Este error sí es correcto si la tabla ya existe
					e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarPiloto( String nombre, int puntuacion ) {
		final String sent = "insert into registro values('" + nombre + "', " + puntuacion + ")";
		//ponemos un hilo
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					statement.executeUpdate(sent);
				} catch (SQLException e) {
					System.out.println( "ERROR EN SENTENCIA SQL: " + sent);
					e.printStackTrace();
				}
			}
		};
		(new Thread(r)).start();
	}
	
	//cerramos la conexion
	public static void finConexion() {
		System.out.println("Cerramos la conexion a la BD");
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
