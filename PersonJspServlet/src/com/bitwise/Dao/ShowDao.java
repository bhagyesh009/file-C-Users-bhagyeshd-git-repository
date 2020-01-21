package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitwise.data.Person;
import com.bitwise.util.JDBCConnection;

public class ShowDao {

	PreparedStatement st = null;
	ResultSet rs = null;
	Connection con = JDBCConnection.jdbcConnection();
	ArrayList<Person> personList = new ArrayList<>();
	
	
	
	public List<Person> showAll(){
		
		String showAllQuery="select id,name,mobno from person where status != 0";
		
		
		
		try {
			st=con.prepareStatement(showAllQuery);
			rs=st.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String mobno = rs.getString(3);
			Person person= new Person(mobno,name,id);
			personList.add(person);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return personList;
	}
	
}
