package com.nalla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) throws SQLException {
		
	
	
	 DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","","");
	
	
	}

}
