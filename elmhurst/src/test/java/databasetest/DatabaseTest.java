package databasetest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Get;

public class DatabaseTest {

	public static void main(String[] args) throws Throwable {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/orcldb", "HR", "HR");
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs= stmt.executeQuery("select * from employees");
		
		List<String> columnValue = new ArrayList<String>();
		
		try {
			while (rs.next()) {
				columnValue.add(rs.getString(1));
				columnValue.add(rs.getString(2));
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
System.out.println(columnValue);
	}

}
