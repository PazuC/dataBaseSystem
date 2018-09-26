package databasesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
	Connection c = null;
	Statement stmt = null;

	DataBase() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:databasesystem.db");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	public void CreateTable() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:databasesystem.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE LIBRARY " + "(ID INT PRIMARY KEY     NOT NULL,"
					+ " NAME           TEXT    NOT NULL, " + " BOOK           CHAR(50)	 NOT NULL, "
					+ " ISBN           KEY)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	public void listStudents() {
		try {
			c.setAutoCommit(false);
			this.stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LIBRARY;");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String book = rs.getString("book");
				int isbn = rs.getInt("isbn");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("BOOK = " + book);
				System.out.println("ISBN = " + isbn);
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public void closeConnection() {
		try {
			c.close();
		} catch (Exception e) {

		}
	}

	public void executeQuery(String sql) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:databasesystem.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			this.stmt = c.createStatement();
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

	public void CheckBorrowBook() {
		try {
			c.setAutoCommit(false);
			this.stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LIBRARY WHERE BOOK IS NOT NULL;");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String book = rs.getString("book");
				int isbn = rs.getInt("isbn");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("BOOK = " + book);
				System.out.println("ISBN = " + isbn);
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	public void CheckBorrowBook(int student_id) {//find by student id
		try {
			c.setAutoCommit(false);
			this.stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LIBRARY WHERE ID = " + student_id);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String book = rs.getString("book");
				int isbn = rs.getInt("isbn");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("BOOK = " + book);
				System.out.println("ISBN = " + isbn);
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	public void CheckBorrowBook(String student_name) {//find by student name
		try {
			c.setAutoCommit(false);
			this.stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM LIBRARY WHERE NAME = '" + student_name +"'");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String book = rs.getString("book");
				int isbn = rs.getInt("isbn");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("BOOK = " + book);
				System.out.println("ISBN = " + isbn);
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
