package databasesystem;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase db = new DataBase();
		db.CreateTable();
		String sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " + "VALUES (1, 'Amy', 'A for apple', 00101 );";
		db.executeQuery(sql);

		sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " + "VALUES (2, 'Billy', 'B for boy', 00102 );";
		db.executeQuery(sql);

		sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " + "VALUES (3, 'Carlos', 'C for cat', 00103 );";
		db.executeQuery(sql);

		sql = "INSERT INTO LIBRARY (ID,NAME,BOOK,ISBN) " + "VALUES (4, 'David', 'D for Dog', 00104 );";
		db.executeQuery(sql);
		
		db.listStudents();
		
		db.CheckBorrowBook(1);
		db.CheckBorrowBook("David");
		db.closeConnection();
	}
}
