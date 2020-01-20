package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitwise.data.Person;
import com.bitwise.util.JDBCConnection;

public class AddDao {

	Connection con= null;
	PreparedStatement st=null;
	ResultSet rs=null;
	public boolean addPerson(Person person) {
		boolean addRecord=false;
		Connection con = JDBCConnection.jdbcConnection();
				
		String insertQuery="insert into person(name,mobno,status) values(?,?,?)";
		try {
			st = con.prepareStatement(insertQuery);
			st.setString(1,person.getName());
			st.setString(2,person.getMobno());
			st.setInt(3, 1);
			int row=st.executeUpdate();
			
			
			
			if(row>0) {
				addRecord=true;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return addRecord;
	}
	
}
