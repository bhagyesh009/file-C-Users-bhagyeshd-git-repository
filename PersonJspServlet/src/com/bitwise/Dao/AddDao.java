package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bitwise.data.Person;
import com.bitwise.util.JDBCConnection;

public class AddDao {

	Connection con= null;
	PreparedStatement st=null;
	ResultSet rs=null;
	public boolean addPerson(Person person) {
		
		Connection con = JDBCConnection.jdbcConnection();
		
		return false;
	}
	
}
