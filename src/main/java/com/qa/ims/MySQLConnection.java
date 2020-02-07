package com.qa.ims;

import java.sql.SQLException;

public class MySQLConnection {
	public static void main(String args[]) throws SQLException {
		Controller con = new Controller();
		con.start();
	}

}
